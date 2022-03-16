	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//Context and Common object(s).
        mContext = getApplicationContext();
        mApp = (Common) getApplicationContext();
        
        //Set the theme and inflate the layout.
        setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Init the UI elements.
        mDrawerParentLayout = (FrameLayout) findViewById(R.id.main_activity_root);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer_root);
        mNavDrawerLayout = (RelativeLayout) findViewById(R.id.nav_drawer_container);
        mCurrentQueueDrawerLayout = (RelativeLayout) findViewById(R.id.current_queue_drawer_container);

        //Load the drawer fragments.
        loadDrawerFragments();
		
        //KitKat specific translucency.
        applyKitKatTranslucency();
        
        //Load the fragment.
        loadFragment(savedInstanceState);
        
    	/**
    	 * Navigation drawer toggle.
    	 */
    	mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 
    			  								  R.drawable.ic_navigation_drawer, 
    			  								  0, 0) {

    		@Override
    		public void onDrawerClosed(View view) {
    			if (mQueueDrawerFragment!=null &&
                    view==mCurrentQueueDrawerLayout)
                    mQueueDrawerFragment.setIsDrawerOpen(false);
    		
    		}

    		@Override
    		public void onDrawerOpened(View view) {
                if (mQueueDrawerFragment!=null &&
                    view==mCurrentQueueDrawerLayout)
                    mQueueDrawerFragment.setIsDrawerOpen(true);

    		}

    	};

    	//Apply the drawer toggle to the DrawerLayout.
    	mDrawerLayout.setDrawerListener(mDrawerToggle);
    	getActionBar().setDisplayHomeAsUpEnabled(true);
    	getActionBar().setDisplayShowHomeEnabled(true);

        //Check if this is the first time the app is being started.
        if (mApp.getSharedPreferences().getBoolean(Common.FIRST_RUN, true)==true) {
            showAlbumArtScanningDialog();
            mApp.getSharedPreferences().edit().putBoolean(Common.FIRST_RUN, false).commit();
        }
    	
	}

