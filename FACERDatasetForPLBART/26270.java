    private void showLocation(boolean locationSuccess) {
        mLocationSucceeded = locationSuccess;
        if (locationSuccess) {
            mTvLocatedCity.setText(CoreManager.getImpl(ILocationApi.class).getLocatedCity().country);
        } else {
            mTvLocatedCity.setText(R.string.city_located_failed);
        }
    }

