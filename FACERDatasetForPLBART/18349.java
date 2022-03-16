    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mContext = getApplicationContext();
        mApp = (Common) mContext;
        mHandler = new Handler();
        mDBColumnsMap = new HashMap<Integer, String>();

        //Set the theme and inflate the layout.
        setTheme();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_sub_grid);

        mHeaderImagePath = getIntent().getExtras().getString("headerImagePath");
        mFragmentId = getIntent().getExtras().getInt("fragmentId");
        mHeaderText = getIntent().getExtras().getString("headerText");
        mHeaderSubText = getIntent().getExtras().getString("subText");

        if (mHeaderText==null || mHeaderText.isEmpty())
            mHeaderText = mContext.getResources().getString(R.string.unknown_genre);

        mHeaderLayout = (RelativeLayout) findViewById(R.id.browser_sub_header_layout);
        mHeaderImage = (ImageView) findViewById(R.id.browser_sub_header_image);
        mHeaderTextView = (TextView) findViewById(R.id.browser_sub_header_text);
        mHeaderSubTextView = (TextView) findViewById(R.id.browser_sub_header_sub_text);
        mGridView = (GridView) findViewById(R.id.browser_sub_grid_view);
        mDrawerParentLayout = (RelativeLayout) findViewById(R.id.browser_sub_drawer_parent);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.browser_sub_drawer_root);
        mNavDrawerLayout = (RelativeLayout) findViewById(R.id.nav_drawer_container);
        mCurrentQueueDrawerLayout = (RelativeLayout) findViewById(R.id.current_queue_drawer_container);
        mPlayAllText = (TextView) findViewById(R.id.browser_sub_play_all);

        mHeaderTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mHeaderTextView.setText(mHeaderText);
        mHeaderTextView.setSelected(true);

        mHeaderSubTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mHeaderSubTextView.setText(mHeaderSubText);
        mHeaderSubTextView.setSelected(true);

        mPlayAllText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mPlayAllText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int playbackRouteId = Common.PLAY_ALL_SONGS;
                switch (mFragmentId) {
                    case Common.ARTISTS_FLIPPED_FRAGMENT:
                        playbackRouteId = Common.PLAY_ALL_BY_ARTIST;
                        break;
                    case Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT:
                        playbackRouteId = Common.PLAY_ALL_BY_ALBUM_ARTIST;
                        break;
                    case Common.GENRES_FLIPPED_FRAGMENT:
                        playbackRouteId = Common.PLAY_ALL_IN_GENRE;
                        break;
                }

                mApp.getPlaybackKickstarter()
                    .initPlayback(mContext,
                            mQuerySelection,
                            playbackRouteId,
                            0,
                            true,
                            false);

            }

        });

        mDrawerParentLayout.setBackgroundColor(UIElementsHelper.getBackgroundColor(mContext));
        applyKitKatTranslucency();

        //Load the drawer fragments.
        loadDrawerFragments();

        //Set the number of gridview columns based on the screen density and orientation.
        if (mApp.isPhoneInLandscape() || mApp.isTabletInLandscape()) {
            mGridView.setNumColumns(4);
        } else if (mApp.isPhoneInPortrait()) {
            mGridView.setNumColumns(2);
        } else if (mApp.isTabletInPortrait()) {
            mGridView.setNumColumns(3);
        }

        //Start the content animations as soon the activity's transition finishes.
        mHandler.postDelayed(animateContent, 300);

        //Start loading the GridView cursor.
        AsyncRunQuery task = new AsyncRunQuery();
        task.execute();

    }

