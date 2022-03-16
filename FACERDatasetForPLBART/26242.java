    @OnClick(R2.id.tv_item_city_name)
    public void onClick() {

        CoreManager.getImpl(IWeatherProvider.class).updateWeather(mCityId);

        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

