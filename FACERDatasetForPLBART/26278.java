        @OnClick(R2.id.tv_hot_city_name)
        void navigationWeather() {
            CoreManager.getImpl(IWeatherProvider.class).updateWeather(mHotCity.mCityId);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }

