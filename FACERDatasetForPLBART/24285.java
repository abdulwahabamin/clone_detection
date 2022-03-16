    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(LOGTAG, "onCreate - " + getIntent());

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        getActionBar().setHomeButtonEnabled(true);

        setContentView(R.layout.audio_player);

        playerHeaderFragment = (PlayerHeaderFragment)getFragmentManager().findFragmentById(R.id.player_header);
        playQueueFragment = (PlayQueueFragment)getFragmentManager().findFragmentById(R.id.playqueue);
        playerFooterFragment = (PlayerFooterFragment)getFragmentManager().findFragmentById(R.id.player_footer);
        playerHeaderDivider = findViewById(R.id.player_header_divider);
        playerFooterDivider = findViewById(R.id.player_footer_divider);

        token = MusicUtils.bindToService(this, this, MobileMediaPlaybackService.class);
    }

