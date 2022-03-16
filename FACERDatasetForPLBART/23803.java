    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() entry.");

        mImageLoader = new ImageLoader(this);
        LocalBroadcastManager servicePlayUpdateBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicService.SERVICE_NOW_PLAYING);
        intentFilter.addAction(MusicService.SERVICE_PAUSED);
        servicePlayUpdateBroadcastManager.registerReceiver(servicePlayingUpdateReceiver, intentFilter);

        playingInfo = restorePreferences();
        displayInfo = new PlayInfo(playingInfo);

        genres = new ArrayList<>();
        currentDisplayPlayList = new ArrayList<>();
        currentDisplayAlbums = new ArrayList<>();

        setupDisplay(displayInfo);

        // If our saved (playing info) is incomplete or missing, then we will "correct" it
        // when setting up the display. So at the end of setupDisplay() our displayInfo
        // will be a better match to the music currently on the phone than playingInfo is.
        playingInfo = new PlayInfo(displayInfo);
    }

