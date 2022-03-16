    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_city);
        overridePendingTransition(0, 0);

        cityId = getIntent().getIntExtra("cityId", -1);
      
        initResources();

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                if(getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(pagerAdapter.getPageTitleForActionBar(position));
                }
                viewPager.setNextFocusRightId(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        viewPager.setCurrentItem(pagerAdapter.getPosForCityID(cityId));
      
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
      
        
        PFASQLiteHelper db = PFASQLiteHelper.getInstance(this);
        if(db.getAllCitiesToWatch().isEmpty()) {
            // no cities selected.. don't show the viewPager - rather show a text that tells the user that no city was selected
            viewPager.setVisibility(View.GONE);
            noCityText.setVisibility(View.VISIBLE);

        } else {
            noCityText.setVisibility(View.GONE);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setAdapter(pagerAdapter);
            viewPager.setCurrentItem(pagerAdapter.getPosForCityID(cityId));
        }
    }

