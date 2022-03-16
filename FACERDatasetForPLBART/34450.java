    @Override
    public void onResume() {
        super.onResume();
        if (mWeatherForecastList.isEmpty()) {
            mWeatherForecastList = AppPreference.loadWeatherForecast(this);
        }
        updateUI();
    }

