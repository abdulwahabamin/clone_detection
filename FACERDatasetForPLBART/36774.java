    private void showEmptyInfo(County county) {
        mTvCountyName.setText(mCounty.getName());
        mTvCountyWeather.setText("");
        mTvNowTemperature.setText(getString(R.string.empty_now_temperature));
        mTvNowTemperatureUnit.setVisibility(View.GONE);

        mTvTodayDayWeather.setText("");
        mTvTodayNightWeather.setText("");
        mTvTodayTemperature.setText("");
        mTvTodayHumidity.setText("");
        mTvTodayRainProbability.setText("");
        mTvTodayVisibility.setText("");

        mTvTomorrowDayWeather.setText("");
        mTvTomorrowTemperature.setText("");

        mTvDayAfterTomorrowDayWeather.setText("");
        mTvDayAfterTomorrowTemperature.setText("");

        mTvUpdateTime.setText("");
    }

