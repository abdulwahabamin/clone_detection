    /**
     * Sets the action bar and adds the required fragment to the layout.
     */
    private void displayContent() {
        setContentView(R.layout.activity_weather_info);

        Intent intent = getIntent();
        WeatherInfoType weatherInfoType = intent.getParcelableExtra(
                RefreshingActivity.WEATHER_INFORMATION_TYPE);
        String jsonString = intent.getStringExtra(RefreshingActivity.WEATHER_INFO_JSON_STRING);
        addRequiredFragment(weatherInfoType, jsonString);

        Toolbar toolbar = (Toolbar) findViewById(R.id.general_toolbar);
        setToolbarTitle(weatherInfoType, toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
    }

