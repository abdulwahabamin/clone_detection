    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate - " + getIntent());

        uri = getIntent().getData();
        title = getIntent().getStringExtra(TITLE);

        buildUI();

        token = MusicUtils.bindToService(this, this, TvMediaPlaybackService.class);
    }

