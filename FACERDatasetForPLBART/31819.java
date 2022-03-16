    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((YourLocalWeather) getApplication()).applyTheme(this);
        super.onCreate(savedInstanceState);
        locationsDbHelper = LocationsDbHelper.getInstance(this);
        weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(this);
        currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(this);
        setContentView(R.layout.activity_main);

        weatherConditionsIcons();
        initializeTextView();
        initializeWeatherReceiver();

        connectionDetector = new ConnectionDetector(MainActivity.this);
        setTitle( R.string.label_activity_main);

        /**
         * Configure SwipeRefreshLayout
         */
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.main_swipe_refresh);
        int top_to_padding = 150;
        mSwipeRefresh.setProgressViewOffset(false, 0, top_to_padding);
        mSwipeRefresh.setColorSchemeResources(R.color.swipe_red, R.color.swipe_green,
                R.color.swipe_blue);
        mSwipeRefresh.setOnRefreshListener(swipeRefreshListener);

        NestedScrollView main_scroll_view = (NestedScrollView) findViewById(R.id.main_scroll_view);
        main_scroll_view.setOnTouchListener(new ActivityTransitionTouchListener(
                null,
                WeatherForecastActivity.class, this));

        updateUI();
        /**
         * Share weather fab
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        this.storedContext = this;
        fab.setOnClickListener(fabListener);
        checkSettingsAndPermisions();
        startAlarms();
        StartAlarmsTask startAlarmsTask = new StartAlarmsTask();
        startAlarmsTask.execute(new Integer[0]);
    }

