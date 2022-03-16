    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_failed_retry: {
                mPresenter.loadData();
            } break;
            case R.id.ib_cities_toolbar_back: {
                onBackPressed();
            } break;
            case R.id.bt_cities_located: {
                navigateToCityWeatherActivity(mLocateCityId);
            } break;
            case R.id.bt_cities_cur: {
                navigateToCityWeatherActivity(mCurCityId);
            } break;
        }
    }

