    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_player);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter(Constants.PLAYER));

        googleClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tiltedView = findViewById(R.id.tilted_view);
        playerBackground = findViewById(R.id.player_background);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary));
        viewPager = (ViewPager) findViewById(R.id.pager);

        artist = (TextView) findViewById(R.id.txt_artist);
        album = (TextView) findViewById(R.id.txt_album);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            songPosition = extras.getInt(SONG_POSITION_PARAM);
            songsList = extras.getParcelableArrayList(SONGS_PARAM);
            PlayBackUtil.setCurrentPlayList(songsList);
            PlayBackUtil.setCurrentSongPosition(songPosition);
        } else {
            songsList = PlayBackUtil.getCurrentPlayList();
            songPosition = PlayBackUtil.getCurrentSongPosition();
        }

        if (songsList != null && songsList.size() > 0) {
            populateSongs(songsList, songPosition);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                PlayBackUtil.setCurrentSongPosition(position);
                if (isWearConnected) {
                    String WEARABLE_DATA_PATH = "/wearable_data";
                    SongDTO currentSong = songsList.get(position);
                    RhythmSong rhythmSong = MusicDataUtility.getSongMeta(currentSong.getSongLocation());
                    DataMap dataMap = new DataMap();
                    dataMap.putString("song_title", rhythmSong.getTrackTitle());
                    dataMap.putByteArray("song_cover", rhythmSong.getImageData());
                    //Requires a new thread to avoid blocking the UI
                    new SendToDataLayerThread(WEARABLE_DATA_PATH, dataMap, googleClient).start();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ViewUtils.drawerClickListener(this);
    }

