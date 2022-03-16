    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_weather);

        mAdapter = new ImageWeatherAdapter(mImageList);
        mLoadMoreListener = new LoadMoreListener(this);
        rvImage.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvImage.addItemDecoration(new StaggeredGridSpacingItemDecoration(ScreenUtils.dp2px(8)));
        rvImage.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(this);
        rvImage.addOnScrollListener(mLoadMoreListener);
        mAdapter.setOnItemClickListener(this);
        fabCamera.setOnClickListener(this);
        fabAlbum.setOnClickListener(this);

        mQuery.setLimit(QUERY_LIMIT);
        mQuery.order("-createdAt");

        LocationManager.get().addLocationObserver(mLocationObserver);
        LocationManager.get().start();

        mRefreshLayout.post(() -> mRefreshLayout.setRefreshing(true));
    }

