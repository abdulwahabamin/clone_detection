    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, rootView);
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this.activity())
                .title(getString(R.string.please_wait))
                .content(getString(R.string.loading))
                .cancelable(false)
                .progress(true, 0);
        pd = builder.build();
        setHasOptionsMenu(true);
        preferences = new Prefs(context());
        weatherFont = Typeface.createFromAsset(activity().getAssets(), "fonts/weather-icons-v2.0.10.ttf");
        fab = ((WeatherActivity) activity()).findViewById(R.id.fab);
        Bundle bundle = getArguments();
        fabProgressCircle = ((WeatherActivity) activity()).findViewById(R.id.fabProgressCircle);
        int mode;
        if (bundle != null)
            mode = bundle.getInt(Constants.MODE, 0);
        else
            mode = 0;
        if (mode == 0)
            updateWeatherData(preferences.getCity(), null, null);
        else
            updateWeatherData(null, Float.toString(preferences.getLatitude()), Float.toString(preferences.getLongitude()));
        gps = new GPSTracker(context());
        cityField.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        updatedField.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        humidityView.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        sunriseIcon.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        sunriseIcon.setTypeface(weatherFont);
        sunriseIcon.setText(activity().getString(R.string.sunrise_icon));
        sunsetIcon.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        sunsetIcon.setTypeface(weatherFont);
        sunsetIcon.setText(activity().getString(R.string.sunset_icon));
        humidityIcon.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        humidityIcon.setTypeface(weatherFont);
        humidityIcon.setText(activity().getString(R.string.humidity_icon));
        windView.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        swipeView.setColorSchemeResources(R.color.red, R.color.green, R.color.blue, R.color.yellow, R.color.orange);
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changeCity(preferences.getCity());
                        swipeView.setRefreshing(false);
                    }
                });
            }
        });
        horizontalLayoutManager
                = new LinearLayoutManager(context(), LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        horizontalRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (horizontalLayoutManager.findLastVisibleItemPosition() == 9 || citys != null)
                    fab.hide();
                else
                    fab.show();
            }
        });
        directionView.setTypeface(weatherFont);
        directionView.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        dailyView.setText(getString(R.string.daily));
        dailyView.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        sunriseView.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        sunsetView.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        button.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        pd.show();
        horizontalRecyclerView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        weatherIcon.setTypeface(weatherFont);
        weatherIcon.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        if (citys == null)
            ((WeatherActivity) activity()).showFab();
        else
            ((WeatherActivity) activity()).hideFab();
        return rootView;
    }

