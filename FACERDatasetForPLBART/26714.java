    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            WeatherJobService.scheduleJob(this);
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        setupToolbar();
        setupFabButton();
        if (findViewById(R.id.city_detail_container) != null) {
            mTwoPane = true;
        }
        setupRecyclerView();
        setupSwipeRefreshLayout();
        loadDataFromDb();
    }

