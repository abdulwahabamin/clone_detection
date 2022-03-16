    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeWeatherForecastReceiver(ForecastWeatherService.ACTION_GRAPHS_UPDATE_RESULT);
        setContentView(R.layout.activity_graphs);
        localityView = (TextView) findViewById(R.id.graph_locality);
        combinedChart = (CombinedChart) findViewById(R.id.combined_chart);
        combinedChartCard = (CardView) findViewById(R.id.combined_chart_card);
        mTemperatureChart = (LineChart) findViewById(R.id.temperature_chart);
        temperatureChartCard = (CardView) findViewById(R.id.temperature_chart_card);
        mWindChart = (LineChart) findViewById(R.id.wind_chart);
        windChartCard = (CardView) findViewById(R.id.wind_chart_card);
        mRainChart = (LineChart) findViewById(R.id.rain_chart);
        rainChartCard = (CardView) findViewById(R.id.rain_chart_card);
        mSnowChart = (LineChart) findViewById(R.id.snow_chart);
        snowChartCard = (CardView) findViewById(R.id.snow_chart_card);
        mPressureChart = (LineChart) findViewById(R.id.pressure_chart);
        pressureChartCard = (CardView) findViewById(R.id.pressure_chart_card);
        rainBarChart = (BarChart) findViewById(R.id.bar_rain_chart);
        rainBarCard = (CardView) findViewById(R.id.rain_bar_chart_card);
        snowBarChart = (BarChart) findViewById(R.id.bar_snow_chart);
        snowBarCard = (CardView) findViewById(R.id.snow_bar_chart_card);
        TextView temperatureLabel = (TextView) findViewById(R.id.graphs_temperature_label);
        temperatureLabel.setText(getString(R.string.label_temperature) +
                                         ", " +
                                        TemperatureUtil.getTemperatureUnit(this));
        TextView windLabel = (TextView) findViewById(R.id.graphs_wind_label);
        windLabel.setText(getString(R.string.label_wind) + ", " + AppPreference.getWindUnit(this));
        TextView rainLabel = (TextView) findViewById(R.id.graphs_rain_label);
        rainLabel.setText(getString(R.string.label_rain) + ", " + getString(AppPreference.getRainOrSnowUnit(this)));
        TextView snowLabel = (TextView) findViewById(R.id.graphs_snow_label);
        snowLabel.setText(getString(R.string.label_snow) + ", " + getString(AppPreference.getRainOrSnowUnit(this)));
        TextView rainBarLabel = (TextView) findViewById(R.id.graphs_bar_rain_label);
        rainBarLabel.setText(getString(R.string.label_rain) + ", " + getString(AppPreference.getRainOrSnowUnit(this)));
        TextView snowBarLabel = (TextView) findViewById(R.id.graphs_bar_snow_label);
        snowBarLabel.setText(getString(R.string.label_snow) + ", " + getString(AppPreference.getRainOrSnowUnit(this)));
        TextView pressureLabel = (TextView) findViewById(R.id.graphs_pressure_label);
        pressureLabel.setText(getString(R.string.label_pressure) + ", " + AppPreference.getPressureUnit(this));
        visibleGraphs = AppPreference.getGraphsActivityVisibleGraphs(this);
        combinedGraphValues = AppPreference.getCombinedGraphValues(this);

        updateUI();
        android.support.v4.widget.NestedScrollView mRecyclerView = (android.support.v4.widget.NestedScrollView) findViewById(R.id.graph_scroll_view);
        mRecyclerView.setOnTouchListener(new ActivityTransitionTouchListener(
                WeatherForecastActivity.class,
                null, this));
    }

