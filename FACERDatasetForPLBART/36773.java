    private void showWeatherInfo(WeatherInfo info) {
        mTvCountyName.setText(info.getCounty().getName());
        mTvCountyWeather.setText(info.getCountyWeather());
        mTvNowTemperature.setText(String.valueOf(info.getNowTemperature()));
        mTvNowTemperatureUnit.setVisibility(View.VISIBLE);

        mTvTodayDayWeather.setText(info.getTodayDayWeather());
        mTvTodayNightWeather.setText(info.getTodayNightWeather());
        mTvTodayTemperature.setText(String.format(Consts.FORMAT_TEMPERATURE, info.getTodayMinTemperature(), info.getTodayMaxTemperature()));
        mTvTodayHumidity.setText(String.format(Consts.FORMAT_HUMIDITY, info.getTodayHumidity()));
        mTvTodayRainProbability.setText(String.format(Consts.FORMAT_RAIN_PROBABILITY, info.getTodayRainProbability()));
        mTvTodayVisibility.setText(String.format(Consts.FORMAT_VISIBILITY, info.getTodayVisibility()));

        mTvTomorrowDayWeather.setText(info.getTodayDayWeather());
        mTvTomorrowTemperature.setText(String.format(Consts.FORMAT_TEMPERATURE, info.getTomorrowMinTemperature(), info.getTomorrowMaxTemperature()));

        mTvDayAfterTomorrowDayWeather.setText(info.getDayAfterTomorrowDayWeather());
        mTvDayAfterTomorrowTemperature.setText(String.format(Consts.FORMAT_TEMPERATURE, info.getDayAfterTomorrowMinTemperature(), info.getDayAfterTomorrowMaxTemperature()));

        mTvUpdateTime.setText(String.format(getString(R.string.format_update_time), DateFormat.format(Consts.FORMAT_DATE_TIME, info.getUpdateTimestamp())));
    }

