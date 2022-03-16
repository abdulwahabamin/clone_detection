    private void updateDataFromNetwork() {
        if (BuildConfig.DEBUG) Log.d("CitiesActivity","updateDataFromNetwork()");
        if (mSwipeRefreshLayout != null) mSwipeRefreshLayout.setRefreshing(true);
         Intent intent = new Intent(this, WeatherService.class);
         startService(intent);
    }

