    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        SharedPrefsHelper helper = new SharedPrefsHelper(this);
        mCountyList = helper.getCounties();
        mPagerAdapter = new CardPagerAdapter(getSupportFragmentManager(), mCountyList);
        mVpMain.setAdapter(mPagerAdapter);
        mCiIndicator.setViewPager(mVpMain);

        FetchCountyListService.start(this);
        FetchWeatherInfoService.startAutoUpdate(this);
    }

