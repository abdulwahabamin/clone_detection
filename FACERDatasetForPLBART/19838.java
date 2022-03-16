	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		mApp = (Common) this.getApplicationContext();
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

		setContentView(R.layout.activity_welcome);
		setTheme(R.style.AppThemeLight);
		
		if (getActionBar()!=null)
			getActionBar().hide();

		welcomeViewPager = (ViewPager) findViewById(R.id.welcome_pager);	
		
		FragmentManager fm = getSupportFragmentManager();
		welcomeViewPager.setAdapter(new WelcomePagerAdapter(fm));
		welcomeViewPager.setOffscreenPageLimit(6);
		
		indicator = (LinePageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(welcomeViewPager);
		
        final float density = getResources().getDisplayMetrics().density;
        indicator.setSelectedColor(0x880099CC);
        indicator.setUnselectedColor(0xFF4F4F4F);
        indicator.setStrokeWidth(2 * density);
        indicator.setLineWidth(30 * density);
        indicator.setOnPageChangeListener(pageChangeListener);

        //Check if the library needs to be rebuilt and this isn't the first run.
        if (getIntent().hasExtra("REFRESH_MUSIC_LIBRARY"))
            showBuildingLibraryProgress();

	}

