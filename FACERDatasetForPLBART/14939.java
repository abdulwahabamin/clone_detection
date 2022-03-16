    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        
        // Landscape mode on phone isn't ready
        if (!ApolloUtils.isTablet(this))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Control Media volume
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // Layout
        setContentView(R.layout.track_browser);
        registerForContextMenu(findViewById(R.id.half_artist_image));

        mBActionbar =(BottomActionBarFragment) getSupportFragmentManager().findFragmentById(R.id.bottomactionbar_new);
        mBActionbar.setUpQueueSwitch(this);
        
        mPanel = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mPanel.setAnchorPoint(0);        
        mPanel.setDragView(findViewById(R.id.bottom_action_bar_dragview));
        mPanel.setShadowDrawable(getResources().getDrawable(R.drawable.above_shadow));
        mPanel.setAnchorPoint(0.0f);
        mPanel.setPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                if (slideOffset < 0.2) {
                    mBActionbar.onExpanded();
                    if (getActionBar().isShowing()) {
                        getActionBar().hide();
                    }
                } else {
                    mBActionbar.onCollapsed();
                    if (!getActionBar().isShowing()) {
                        getActionBar().show();
                    }
                }
            }
            @Override
            public void onPanelExpanded(View panel) {}
            @Override
            public void onPanelCollapsed(View panel) {}
            @Override
            public void onPanelAnchored(View panel) {}
        });
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

