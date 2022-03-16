    @Override
    public void initData() {
        ButterKnife.bind(this);
        FragmentManager fm = getSupportFragmentManager();
        HomeFragment homeFragment = (HomeFragment) fm.findFragmentById(R.id.fragment_container);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            fm.beginTransaction().add(R.id.fragment_container,homeFragment).commit();
        }

        mHomePresenter = new HomePresenter(homeFragment);
        BDLocationListener myListener = new MyLocationListener();
        MyApplication.getmLocationClient().registerLocationListener(myListener);

//
    }

