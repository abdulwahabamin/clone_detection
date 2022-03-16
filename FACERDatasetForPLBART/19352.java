    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	//Inflate the correct layout based on the selected theme.
        mContext = getActivity().getApplicationContext();
        mApp = (Common) mContext;
        nowPlayingQueueFragment = this;
        sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
        
        mCursor = mApp.getService().getCursor();
        View rootView = (ViewGroup) inflater.inflate(R.layout.now_playing_queue_layout, container, false);

        receiver = new BroadcastReceiver() {
        	
            @Override
            public void onReceive(Context context, Intent intent) {
                updateSongInfo();
            }
            
        };
        
        //Notify the application that this fragment is now visible.
        sharedPreferences.edit().putBoolean("NOW_PLAYING_QUEUE_VISIBLE", true).commit();
        
    	//Get the screen's parameters.
	    displayMetrics = new DisplayMetrics();
	    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
	    screenWidth = displayMetrics.widthPixels;
	    screenHeight = displayMetrics.heightPixels;
        
        noMusicPlaying = (TextView) rootView.findViewById(R.id.now_playing_queue_no_music_playing);
        nowPlayingAlbumArt = (ImageView) rootView.findViewById(R.id.now_playing_queue_album_art);
        nowPlayingSongTitle = (TextView) rootView.findViewById(R.id.now_playing_queue_song_title);
        nowPlayingSongArtist = (TextView) rootView.findViewById(R.id.now_playing_queue_song_artist);
        nowPlayingSongContainer = (RelativeLayout) rootView.findViewById(R.id.now_playing_queue_current_song_container);
        
        noMusicPlaying.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
        nowPlayingSongTitle.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
        nowPlayingSongArtist.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
        
        nowPlayingQueueListView = (DragSortListView) rootView.findViewById(R.id.now_playing_queue_list_view);
        progressBar = (ProgressBar) rootView.findViewById(R.id.now_playing_queue_progressbar);
        playPauseButton = (ImageButton) rootView.findViewById(R.id.now_playing_queue_play);
        nextButton = (ImageButton) rootView.findViewById(R.id.now_playing_queue_next);
        previousButton = (ImageButton) rootView.findViewById(R.id.now_playing_queue_previous);
        
		//Apply the card layout's background based on the color theme.
		if (sharedPreferences.getString(Common.CURRENT_THEME, "LIGHT_CARDS_THEME").equals("LIGHT_CARDS_THEME")) {
			rootView.setBackgroundColor(0xFFEEEEEE);
			nowPlayingQueueListView.setDivider(getResources().getDrawable(R.drawable.transparent_drawable));
			nowPlayingQueueListView.setDividerHeight(3);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			layoutParams.setMargins(7, 3, 7, 3);
			nowPlayingQueueListView.setLayoutParams(layoutParams);
		} else if (sharedPreferences.getString(Common.CURRENT_THEME, "LIGHT_CARDS_THEME").equals("DARK_CARDS_THEME")) {
			rootView.setBackgroundColor(0xFF000000);
			nowPlayingQueueListView.setDivider(getResources().getDrawable(R.drawable.transparent_drawable));
			nowPlayingQueueListView.setDividerHeight(3);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			layoutParams.setMargins(7, 3, 7, 3);
			nowPlayingQueueListView.setLayoutParams(layoutParams);
		}
        
        //Set the Now Playing container layout's background.
        nowPlayingSongContainer.setBackgroundColor(UIElementsHelper.getNowPlayingQueueBackground(mContext));
        
        //Loop through the service's cursor and retrieve the current queue's information.
        if (sharedPreferences.getBoolean("SERVICE_RUNNING", false)==false || mApp.getService().getCurrentMediaPlayer()==null) {
        	
        	//No audio is currently playing.
        	noMusicPlaying.setVisibility(View.VISIBLE);
        	nowPlayingAlbumArt.setImageBitmap(mApp.decodeSampledBitmapFromResource(R.drawable.default_album_art, screenWidth/3, screenWidth/3));
        	nowPlayingQueueListView.setVisibility(View.GONE);
        	nowPlayingSongTitle.setVisibility(View.GONE);
        	nowPlayingSongArtist.setVisibility(View.GONE);
        	progressBar.setVisibility(View.GONE);
        	
        } else {
        	
        	//Set the current play/pause conditions.
        	try {
        		
        		//Hide the progressBar and display the controls.
        		progressBar.setVisibility(View.GONE);
        		playPauseButton.setVisibility(View.VISIBLE);
        		nextButton.setVisibility(View.VISIBLE);
        		previousButton.setVisibility(View.VISIBLE);
        		
        		if (mApp.getService().getCurrentMediaPlayer().isPlaying()) {
        			playPauseButton.setImageResource(R.drawable.pause_holo_light);
        		} else {
        			playPauseButton.setImageResource(R.drawable.play_holo_light);
        		}
        	} catch (Exception e) {
        		/* The mediaPlayer hasn't been initialized yet, so let's just keep the controls 
        		 * hidden for now. Once the mediaPlayer is initialized and it starts playing, 
        		 * updateSongInfo() will be called, and we can show the controls/hide the progressbar 
        		 * there. For now though, we'll display the progressBar.
        		 */
        		progressBar.setVisibility(View.VISIBLE);
        		playPauseButton.setVisibility(View.GONE);
        		nextButton.setVisibility(View.GONE);
        		previousButton.setVisibility(View.GONE);
        	}
        	
    		//Retrieve and set the current title/artist/artwork.
    		mCursor.moveToPosition(mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()));
    		String currentTitle = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_TITLE));
    		String currentArtist = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
    		
    		nowPlayingSongTitle.setText(currentTitle);
    		nowPlayingSongArtist.setText(currentArtist);
    		
    		File file = new File(mContext.getExternalCacheDir() + "/current_album_art.jpg");
    		Bitmap bm = null;
    		if (file.exists()) {
    			bm = mApp.decodeSampledBitmapFromFile(file, screenWidth, screenHeight);
    			nowPlayingAlbumArt.setScaleX(1.0f);
    			nowPlayingAlbumArt.setScaleY(1.0f);
    		} else {
    			int defaultResource = UIElementsHelper.getIcon(mContext, "default_album_art");
    			bm = mApp.decodeSampledBitmapFromResource(defaultResource, screenWidth, screenHeight);
    			nowPlayingAlbumArt.setScaleX(0.5f);
    			nowPlayingAlbumArt.setScaleY(0.5f);
    		}
    		
    		nowPlayingAlbumArt.setImageBitmap(bm);
            noMusicPlaying.setPaintFlags(noMusicPlaying.getPaintFlags() 
            							 | Paint.ANTI_ALIAS_FLAG
            							 | Paint.SUBPIXEL_TEXT_FLAG);
            
            nowPlayingSongTitle.setPaintFlags(nowPlayingSongTitle.getPaintFlags() 
    									 	  | Paint.ANTI_ALIAS_FLAG 
    									 	  | Paint.FAKE_BOLD_TEXT_FLAG
    									 	  | Paint.SUBPIXEL_TEXT_FLAG);
            
            nowPlayingSongArtist.setPaintFlags(nowPlayingSongArtist.getPaintFlags() 
    									 	   | Paint.ANTI_ALIAS_FLAG
    									 	   | Paint.SUBPIXEL_TEXT_FLAG);
            
            /* Set the adapter. We'll pass in playbackIndecesList as the adapter's data backend.
             * The array can then be manipulated (reordered, items removed, etc) with no restrictions. 
             * Each integer element in the array will be used as a pointer to a specific cursor row, 
             * so there's no need to fiddle around with the actual cursor itself. */
            nowPlayingQueueListViewAdapter = new NowPlayingQueueListViewAdapter(getActivity(), mApp.getService().getPlaybackIndecesList());
            
            nowPlayingQueueListView.setAdapter(nowPlayingQueueListViewAdapter);
    		nowPlayingQueueListView.setFastScrollEnabled(true);
    		nowPlayingQueueListView.setDropListener(onDrop);
    		nowPlayingQueueListView.setRemoveListener(onRemove);
    		SimpleFloatViewManager simpleFloatViewManager = new SimpleFloatViewManager(nowPlayingQueueListView);
    		simpleFloatViewManager.setBackgroundColor(Color.TRANSPARENT);
    		nowPlayingQueueListView.setFloatViewManager(simpleFloatViewManager);
            
    		//Scroll down to the current song.
    		nowPlayingQueueListView.setSelection(mApp.getService().getCurrentSongIndex());
    		
            nowPlayingQueueListView.setOnItemClickListener(new OnItemClickListener() {

    			@Override
    			public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {
    				mApp.getService().skipToTrack(index);
    				
    			}
            	
            });
            
            playPauseButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					mApp.getService().togglePlaybackState();
				}
            	
            });
            
            nextButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mApp.getService().skipToNextTrack();
				}
            	
            });
            
            previousButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mApp.getService().skipToPreviousTrack();
				}
            	
            });
            
        }
        		
        return rootView;
    }

