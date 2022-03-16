    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        localDataSource = ((WeatherApp) getApplicationContext()).getLocalDataSource();
        service = GeoNameApiClient.getClient().create(GeoNamesService.class);
        setupRecyclerView();
        mSearchState = (TextView) findViewById(R.id.textView);
        mImageView = (SimpleDraweeView) findViewById(R.id.imageView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        assert mProgressBar != null;
        mProgressBar.setVisibility(View.GONE);
        mCityListView = findViewById(R.id.city_search_list_container);
        if (mCityListView != null) {
            mCityListView.setVisibility(View.GONE);
        }
    }

