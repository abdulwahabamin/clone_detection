    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        String cityName = getIntent().getStringExtra(CityDetailFragment.ARG_ITEM_NAME);
        if (cityName != null) {
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(cityName);
            } else if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(cityName);
            }
        }
        String imageName = getIntent().getStringExtra(IMAGE_NAME);
        SimpleDraweeView imageView = (SimpleDraweeView) findViewById(R.id.backdrop);
        if (imageView != null && !TextUtils.isEmpty(imageName)) {
            imageView.setImageURI(Uri.parse("asset:///"+ imageName + ".jpg"));
        }
        boolean waitAnimations = false;
        if (getResources().getConfiguration().orientation == OrientationHelper.VERTICAL &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String transitionName = getIntent().getStringExtra(TRANSITION_NAME);
            if (imageView != null && !TextUtils.isEmpty(transitionName)) {
                waitAnimations = true;
                initEnterAnimation();
                imageView.setTransitionName(transitionName);
            }
        }
        if (savedInstanceState == null) {
            long cityId = getIntent().getLongExtra(CityDetailFragment.ARG_ITEM_ID, 0);
            CityDetailFragment fragment = CityDetailFragment.getInstance(cityId, cityName);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.city_detail_container, fragment)
                    .commit();
            if (waitAnimations) {
                fragment.waitAnimations();
            }
        }
    }

