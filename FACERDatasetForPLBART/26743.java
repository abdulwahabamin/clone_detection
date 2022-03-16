    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(LocationEvent event) {
        Log.d(LOG_TAG, "LocationEvent location=" + event.getCity());
        OrmCity yourCity = new OrmCity((long)1, event.getCity(), event.getRegion(),
                event.getCountry(), lastLocation.getLatitude(), lastLocation.getLongitude());
        localDataSource.saveCity(yourCity);
    }

