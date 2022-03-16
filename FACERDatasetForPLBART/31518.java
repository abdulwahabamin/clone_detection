    @Override
    protected void initView() {
        setContentView(R.layout.activity_settings);
        //mUnbinder = ButterKnife.bind(this);

        ibToolbarBack = (ImageButton)findViewById(R.id.ib_settings_toolbar_back);
        rlAutoUpdate = (RelativeLayout)findViewById(R.id.rl_settings_auto_update);
        tvAutoUpdateVal = (TextView)findViewById(R.id.tv_settings_auto_update_value);
        llNotificationWeather = (LinearLayout)findViewById(R.id.ll_settings_notification_weather);
        ivShouldNotify = (ImageView)findViewById(R.id.iv_settings_notification_weather_value);
        llAbout = (LinearLayout)findViewById(R.id.ll_settings_about);

        ibToolbarBack.setOnClickListener(this);
        rlAutoUpdate.setOnClickListener(this);
        llNotificationWeather.setOnClickListener(this);
        llAbout.setOnClickListener(this);

        mPresenter = new SettingsPresenter(this);
    }

