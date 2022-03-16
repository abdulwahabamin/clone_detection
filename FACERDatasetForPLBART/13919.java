    @Override
    protected void onCreate(Bundle icicle) {
        // For the theme chooser and overflow MenuItem
        if (ThemeUtils.overflowLight(this)) {
            setTheme(R.style.Apollo_Holo);
        } else {
            setTheme(R.style.Apollo_Holo_Light);
        }
        // Landscape mode on phone isn't ready
        if (!ApolloUtils.isTablet(this))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Control Media volume
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // Layout
        setContentView(R.layout.audio_player_browser);

        // Set up the colorstrip
        initColorstrip();

        // Set up the ActionBar
        initActionBar();

        // Important!
        initPager();
        super.onCreate(icicle);
    }

