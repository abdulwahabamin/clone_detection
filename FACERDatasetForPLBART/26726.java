    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoadingStatusEvent event) {
        switch (event.getStatus()) {
            case WeatherService.SYNC_START:
                if (BuildConfig.DEBUG) {
                    Toast.makeText(CitiesActivity.this,"Sync start",Toast.LENGTH_SHORT).show();
                }
                break;
            case WeatherService.SYNC_END:
                if (BuildConfig.DEBUG) {
                    Toast.makeText(CitiesActivity.this,"Sync complete",Toast.LENGTH_SHORT).show();
                }
                if (mSwipeRefreshLayout!=null) mSwipeRefreshLayout.setRefreshing(false);
                loadDataFromDb();
                break;
            case WeatherService.SYNC_NO_INTERNET:
                    Toast.makeText(CitiesActivity.this,getString(R.string.no_internet),Toast.LENGTH_SHORT).show();
                break;
            case WeatherService.SYNC_ERROR:
                    Toast.makeText(CitiesActivity.this, getString(R.string.error_load_data), Toast.LENGTH_SHORT).show();
                break;
        }
    }

