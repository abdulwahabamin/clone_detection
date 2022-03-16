    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        selectCityFragment = (SelectCityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (selectCityFragment == null) {
            selectCityFragment = SelectCityFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), selectCityFragment, R.id.fragment_container);
        }

        DaggerSelectCityComponent.builder()
                .applicationComponent(WeatherApplication.getInstance().getApplicationComponent())
                .selectCityModule(new SelectCityModule(selectCityFragment))
                .build().inject(this);
    }

