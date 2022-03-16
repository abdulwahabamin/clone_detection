    @Override
    protected void initView() {
        setContentView(R.layout.activity_city_weather);
        //mUnbinder = ButterKnife.bind(this);

        rlLoadingProgress = (RelativeLayout)findViewById(R.id.rl_loading_progress);
        rlFailedRetry = (RelativeLayout)findViewById(R.id.rl_failed_retry);
        srlCityWeather = (SwipeRefreshLayout)findViewById(R.id.srl_city_weather);
        rvCityWeather = (RecyclerView)findViewById(android.R.id.list);
        btFailedRetry = (Button)findViewById(R.id.bt_failed_retry);
        tvToolbarTitle = (TextView)findViewById(R.id.tv_city_weather_toolbar_title);
        ibToolbarCities = (ImageButton)findViewById(R.id.ib_city_weather_toolbar_cities);
        ibToolbarMenu = (ImageButton)findViewById(R.id.ib_city_weather_toolbar_menu);
        rlBackgroundView = (RelativeLayout)findViewById(R.id.rl_city_weather_background_view);

        btFailedRetry.setOnClickListener(this);
        ibToolbarCities.setOnClickListener(this);
        ibToolbarMenu.setOnClickListener(this);
        srlCityWeather.setOnRefreshListener(this);
        srlCityWeather.setColorSchemeResources(R.color.colorLightGreen, R.color.colorLigthBlue, R.color.colorLightRed);

        Intent intent = getIntent();
        String cityId = intent.getStringExtra(CITY_ID);
        FileUtil.putStringToPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_CITY_ID, cityId);

        mPresenter = new CityWeatherPresenter();
        mPresenter.attachView(this, cityId);
        mPresenter.start();

        rvCityWeather.setHasFixedSize(true);
        rvCityWeather.setLayoutManager(new LinearLayoutManager(this));
        mCityWeatherAdapter = new CityWeatherAdapter(this, mPresenter, rvCityWeather);
        rvCityWeather.setAdapter(mCityWeatherAdapter);
        rvCityWeather.setItemViewCacheSize(4);
        rvCityWeather.addOnScrollListener(new CityWeatherScrollListener());

        View popMenuView = getLayoutInflater().inflate(R.layout.ll_city_weather_pop_menu, null);
        if (popMenuView != null) {
            mPopupMenu = new PopupWindow(popMenuView, DensityUtil.dp2px(getApplicationContext(), 120), ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupMenu.setBackgroundDrawable(new ColorDrawable(0));
            mPopupMenu.setFocusable(true);
            View refreshView = popMenuView.findViewById(R.id.ll_pop_menu_item_refresh);
            refreshView.setOnClickListener(this);
            View settingsView = popMenuView.findViewById(R.id.ll_pop_menu_item_settings);
            settingsView.setOnClickListener(this);
        }
    }

