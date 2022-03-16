    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Preferences.updateNightMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mNavigationView.setNavigationItemSelectedListener(this);
        fabSpeech.setOnClickListener(this);
        mRefreshLayout.setOnRefreshListener(this);

        WeatherContract.Model model = new WeatherRepository(this);
        presenter = new WeatherPresenter(model, this);
        speechPresenter = new WeatherSpeechPresenter(model, this);

        presenter.onCreate();
        speechPresenter.onCreate();
    }

