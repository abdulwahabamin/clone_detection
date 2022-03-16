    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bgView = (ImageView) findViewById(R.id.bgView);
        circularSeekBar = (CircularSeekBar) findViewById(R.id.circularProgressBar);
        circularSeekBar.setOnSeekBarChangeListener(onCircularSeekBarChangeListener);
        albumArt = (ImageView) findViewById(R.id.albumArt);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        titleView = (TextView) findViewById(R.id.title);
        subTitleView = (TextView) findViewById(R.id.subTitle);
        startTv = (TextView) findViewById(R.id.startText);
        endTv = (TextView) findViewById(R.id.endText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        previousBtn = (ImageButton) findViewById(R.id.previous);
        previousBtn.setOnClickListener(onClickListener);
        playPauseBtn = (ImageButton) findViewById(R.id.playPause);
        playPauseBtn.setOnClickListener(onClickListener);
        nextBtn = (ImageButton) findViewById(R.id.next);
        nextBtn.setOnClickListener(onClickListener);

        pauseDrawable = ContextCompat.getDrawable(this, R.drawable.ic_media_pause_circle);
        playDrawable = ContextCompat.getDrawable(this, R.drawable.ic_media_play_circle);

        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

        // Only update from the intent if we are not recreating from a config change:
        if (savedInstanceState == null) {
            updateFromParams(getIntent());
        }

        mediaBrowser = new MediaBrowserCompat(this,
                new ComponentName(this, MusicPlayerService.class),
                mediaBrowserConnectionCallback, null);
    }

