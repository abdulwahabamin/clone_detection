    @Override
    public void navigateToCityWeatherActivity(String cityId) {
        mCityId = cityId;
        Message message = mHandler.obtainMessage(MSG_NAVIGATE_CITY_WEATHER);
        message.sendToTarget();
    }

