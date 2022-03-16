  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hourly);
    ButterKnife.bind(this);
    setVariables();
    initRecyclerView();
    showItemHourlyDB();
    setupDismissFrameLayout();
  }

