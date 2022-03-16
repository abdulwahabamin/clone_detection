    private void updateBaseWeatherInfo(WeatherData.BasicEntity basicData) {
        if(basicData == null) {
            return;
        }

        mLocationTv.setCompoundDrawables(mWeatherModel.locationIsCurrent()? mDrawableLocation : null, null, null, null);
        mLocationTv.setText(basicData.getCity());
        mUpdateTime = String.format(getString(R.string.weather_post), TimeUtil.getTimeTips(basicData.getTime()));

        mTemperature = basicData.getTemp();
        mWeatherStatus = basicData.getWeather();

        mMainTemp.setText(mTemperature);
        mMainInfoTv.setText(mWeatherStatus);

        if (TimeUtil.isNight()) {
            if (ResourceProvider.sunny(mWeatherStatus)) {
                mMainBgIv.setBackgroundResource(R.mipmap.weather_bg_night);
            } else {
                mMainBgIv.setBackgroundResource(R.mipmap.weather_bg_night_dark);
            }
        } else {
            mMainBgIv.setBackgroundResource(R.mipmap.weather_bg_day);
        }

    }

