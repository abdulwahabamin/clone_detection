    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Landscape mode on phone isn't ready
        if (!ApolloUtils.isTablet(this))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Control Media volume
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // Layout
        setContentView(R.layout.track_browser);
        registerForContextMenu(findViewById(R.id.half_artist_image));

        //ImageCache
    	mImageProvider = ImageProvider.getInstance( this );

        // Important!
        whatBundle(icicle);

        // Update the colorstrip color
        initColorstrip();

        // Update the ActionBar
        initActionBar();

        // Update the half_and_half layout
        initUpperHalf();

        // Important!
        initPager();
    }

