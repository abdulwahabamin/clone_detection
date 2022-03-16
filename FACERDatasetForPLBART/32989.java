    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeWeatherForecastReceiver(ForecastWeatherService.ACTION_FORECAST_UPDATE_RESULT);
        setContentView(R.layout.activity_weather_forecast);

        mRecyclerView = (RecyclerView) findViewById(R.id.forecast_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        localityView = (TextView) findViewById(R.id.forecast_locality);
        visibleColumns = AppPreference.getForecastActivityColumns(this);
        connectionDetector = new ConnectionDetector(WeatherForecastActivity.this);
        updateUI();


        mRecyclerView.setOnTouchListener(new ActivityTransitionTouchListener(
                MainActivity.class,
                GraphsActivity.class, this));
    }

