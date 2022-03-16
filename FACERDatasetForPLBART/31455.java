    @Override
    protected void initView() {
        setContentView(R.layout.activity_cities);

        rlLoadingProgress = (RelativeLayout)findViewById(R.id.rl_loading_progress);
        rlFailedRetry = (RelativeLayout)findViewById(R.id.rl_failed_retry);
        btFailedRetry = (Button)findViewById(R.id.bt_failed_retry);
        etCityName = (EditText)findViewById(R.id.et_cities_city_name);
        lvCandidates = (ListView)findViewById(R.id.lv_cities_candidates);
        tvToolbarTitle = (TextView)findViewById(R.id.tv_cities_toolbar_title);
        ibToolbarBack = (ImageButton)findViewById(R.id.ib_cities_toolbar_back);
        btLocatedCityName = (Button)findViewById(R.id.bt_cities_located);
        btCurCityName = (Button)findViewById(R.id.bt_cities_cur);
        llLocated = (LinearLayout)findViewById(R.id.ll_cities_located);
        llCitiesRoot = (LinearLayout)findViewById(R.id.ll_cities_root);

        //mUnbinder = ButterKnife.bind(this);
        lvCandidates.setOnItemClickListener(this);
        ibToolbarBack.setOnClickListener(this);
        btLocatedCityName.setOnClickListener(this);
        btCurCityName.setOnClickListener(this);
        btFailedRetry.setOnClickListener(this);
        etCityName.addTextChangedListener(this);
        tvToolbarTitle.setText(R.string.city_selection);

        Intent intent = getIntent();
        mLocateCityId = intent.getStringExtra(LOC_CITY_ID);
        mCurCityId = intent.getStringExtra(CITY_ID);
        mIsLocateSucceeded = intent.getBooleanExtra(LOCATE_RESULT, false);

        mPresenter = new CitiesPresenter(this);
        mPresenter.getBackgroundImage(llCitiesRoot, R.drawable.city);
        mPresenter.getImageViewSrc(ibToolbarBack, R.drawable.ic_arrow_back_white_24dp);
        mPresenter.setLocatedCityId(mLocateCityId, mCurCityId);
    }

