  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    initSearchView();
    initValues();
    setupTextSwitchers();
    initRecyclerView();
    showStoredCurrentWeather();
    showStoredFiveDayWeather();
    checkLastUpdate();
  }

