    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate - " + getIntent());

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        setContentView(R.layout.tv_browser_activity);

        token = MusicUtils.bindToService(this, this, TvMediaPlaybackService.class);
    }

