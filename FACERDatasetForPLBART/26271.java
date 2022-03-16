    @OnClick(R2.id.location_layout)
    void locate() {
        if (mLocationSucceeded) {
            CoreManager.getImpl(IWeatherProvider.class).updateWeather(CoreManager.getImpl(ILocationApi.class).getLocatedCityId());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } else {
            CoreManager.getImpl(ILocationApi.class).startLocation();
            mTvLocatedCity.setText(R.string.city_locating);
        }
    }

