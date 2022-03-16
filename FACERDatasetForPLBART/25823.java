    private void onWeatherUpdate(boolean succeed) {

        if (succeed) {
            updateBaseWeatherInfo(mWeatherModel.getWeatherBaseData());
            mHoursForecastAdapter.setData(mWeatherModel.getHoursDatas());
            updateSucceed(mUpdateTime);
        } else {
            mPostTimeTv.setText(R.string.weather_refresh_fail);
        }
        stopRefreshing();

    }

