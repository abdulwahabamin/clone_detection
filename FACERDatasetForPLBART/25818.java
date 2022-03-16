    private void setupViewPager() {
        MainPageAdapter adapter = new MainPageAdapter(this, getSupportFragmentManager());

        Pair<BaseFragment, Integer> cityFragmentPair = CoreManager.getImpl(ICityProvider.class).provideCityFragment();
        adapter.addFrag(cityFragmentPair);

        BaseFragment weatherFragment = WeatherFragment.newInstance();
        adapter.addFrag(new Pair<>(weatherFragment,R.drawable.weather_tab_drawable));

        Pair<BaseFragment,Integer> settingFragment = CoreManager.getImpl(ISettingProvider.class).provideSettingFragment();
        adapter.addFrag(settingFragment);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for(int index =0 ;index < adapter.getCount();index++) {
            mTabLayout.getTabAt(index).setCustomView(adapter.getTabView(index, mTabLayout));
        }

        mViewPager.setOffscreenPageLimit(adapter.getCount());
        mViewPager.setCurrentItem(adapter.getCount()/2);

    }

