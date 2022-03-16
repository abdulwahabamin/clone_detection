	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent originIntent = getIntent();
		if(originIntent.getBooleanExtra("From_Notification", false)){

			String artistName = originIntent.getStringExtra(ArtistList.ARTIST_NAME);
			String artistAbsPath = originIntent.getStringExtra(ArtistList.ARTIST_ABS_PATH_NAME);
			if(artistName != null && artistAbsPath != null){
				Log.i(TAG, "Now Playing was launched from a notification, setting up its back stack");
				// Reference: https://developer.android.com/reference/android/app/TaskStackBuilder.html
				TaskStackBuilder tsb = TaskStackBuilder.create(this);
				Intent intent = new Intent(this, ArtistList.class);
				tsb.addNextIntent(intent);

				intent = new Intent(this, AlbumList.class);
				intent.putExtra(ArtistList.ARTIST_NAME, artistName);
				intent.putExtra(ArtistList.ARTIST_ABS_PATH_NAME, artistAbsPath);
				tsb.addNextIntent(intent);

				String albumName =  originIntent.getStringExtra(AlbumList.ALBUM_NAME);
				if(albumName != null){
					intent = new Intent(this, SongList.class);
					intent.putExtra(AlbumList.ALBUM_NAME, albumName);
					intent.putExtra(ArtistList.ARTIST_NAME, artistName);
					intent.putExtra(ArtistList.ARTIST_ABS_PATH_NAME, artistAbsPath);
					tsb.addNextIntent(intent);
				}
				intent = new Intent(this, NowPlaying.class);
				tsb.addNextIntent(intent);
				tsb.startActivities();
			}

		}

		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		String theme = sharedPref.getString("pref_theme", getString(R.string.light));
		String size = sharedPref.getString("pref_text_size", getString(R.string.medium));
		Log.i(TAG, "got configured theme " + theme);
		Log.i(TAG, "got configured size " + size);
		
        // These settings were fixed in english for a while, so check for old style settings as well as language specific ones.
        if(theme.equalsIgnoreCase(getString(R.string.dark)) || theme.equalsIgnoreCase("dark")){
        	Log.i(TAG, "setting theme to " + theme);
        	if(size.equalsIgnoreCase(getString(R.string.small)) || size.equalsIgnoreCase("small")){
        		setTheme(R.style.PGMPDarkSmall);
        	} else if (size.equalsIgnoreCase(getString(R.string.medium)) || size.equalsIgnoreCase("medium")){
        		setTheme(R.style.PGMPDarkMedium);
        	} else {
        		setTheme(R.style.PGMPDarkLarge);
        	}
        } else if (theme.equalsIgnoreCase(getString(R.string.light)) || theme.equalsIgnoreCase("light")){
        	Log.i(TAG, "setting theme to " + theme);
        	if(size.equalsIgnoreCase(getString(R.string.small)) || size.equalsIgnoreCase("small")){
        		setTheme(R.style.PGMPLightSmall);
        	} else if (size.equalsIgnoreCase(getString(R.string.medium)) || size.equalsIgnoreCase("medium")){
        		setTheme(R.style.PGMPLightMedium);
        	} else {
        		setTheme(R.style.PGMPLightLarge);
        	}
        }

		boolean fullScreen = sharedPref.getBoolean("pref_full_screen_now_playing", false);
		currentFullScreen = fullScreen;
		if(fullScreen){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		} else {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		setContentView(R.layout.activity_now_playing);

		if(savedInstanceState == null){
			doBindService(true);
			startPlayingRequired = true;
		} else {
			doBindService(false);
			startPlayingRequired = false;
		}

		// Get the message from the intent
		Intent intent = getIntent();
		if(intent.getBooleanExtra(KICKOFF_SONG, false)){
			desiredArtistName = intent.getStringExtra(ArtistList.ARTIST_NAME);
			desiredAlbumName = intent.getStringExtra(AlbumList.ALBUM_NAME);
			desiredArtistAbsPath = intent.getStringExtra(ArtistList.ARTIST_ABS_PATH_NAME);
			desiredSongAbsFileNames = intent.getStringArrayExtra(SongList.SONG_ABS_FILE_NAME_LIST);
			desiredAbsSongFileNamesPosition = intent.getIntExtra(SongList.SONG_ABS_FILE_NAME_LIST_POSITION, 0);
			desiredSongProgress = intent.getIntExtra(MusicPlaybackService.TRACK_POSITION, 0);

			Log.d(TAG, "Got song names " + desiredSongAbsFileNames + " position "
					+ desiredAbsSongFileNamesPosition);

			TextView et = (TextView) findViewById(R.id.artistName);
			et.setText(desiredArtistName);

			et = (TextView) findViewById(R.id.albumName);
			et.setText(desiredAlbumName);
		}

		// The song name field will be set when we get our first update update from the service.

		final ImageButton pause = (ImageButton) findViewById(R.id.playPause);
		pause.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				playPause();
			}

		});

		ImageButton previous = (ImageButton) findViewById(R.id.previous);
		previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				previous();
			}

		});
		
		previous.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				jumpBack();
				return true;
			}
		});

		ImageButton next = (ImageButton) findViewById(R.id.next);
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				next();
			}
		});

		final ImageButton shuffle = (ImageButton) findViewById(R.id.shuffle);
		shuffle.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				toggleShuffle();
			}
		});
		
		final ImageButton jumpback = (ImageButton) findViewById(R.id.jumpback);
		jumpback.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				jumpBack();
			}
		});

		SeekBar seekBar = (SeekBar)findViewById(R.id.songProgressBar);
		seekBar.setEnabled(true);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			private int requestedProgress;

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(fromUser){
					Log.v(TAG, "drag location updated..." + progress);
					this.requestedProgress = progress;
					updateSongProgressLabel(progress);
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				NowPlaying.this.userDraggingProgress = true;

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Message msg = Message.obtain(null, MusicPlaybackService.MSG_SEEK_TO);
				msg.getData().putInt(MusicPlaybackService.TRACK_POSITION, requestedProgress);
				try {
					Log.i(TAG, "Sending a request to seek!");
					mService.send(msg);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				NowPlaying.this.userDraggingProgress = false;
			}

		});
		
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.smithdtyler.ACTION_EXIT");
        exitReceiver = new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				Log.i(TAG, "Received exit request, shutting down...");
				Intent msgIntent = new Intent(getBaseContext(), MusicPlaybackService.class);
				msgIntent.putExtra("Message", MusicPlaybackService.MSG_STOP_SERVICE);
				startService(msgIntent);
				finish();
			}
        	
        };
        registerReceiver(exitReceiver, intentFilter);
	}

