    @OnClick({R2.id.content, R2.id.delete})
    void onClick(View view) {
        int i = view.getId();
        if (i == R.id.content) {
            if (!mCityWeatherAdapter.mIsDeleting) {
                CoreManager.getImpl(IWeatherProvider.class).updateWeather(mFollowedCityData.cityId);
            }
            updateAdapter(false);

        } else if (i == R.id.delete) {
            mCityModel.deleteFollowedWeather(mFollowedCityData.cityId);
            updateAdapter(true);

        }
    }

