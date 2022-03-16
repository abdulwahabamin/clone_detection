    @Override
    protected void onResume() {
        super.onResume();
        mForecastList = AppPreference.loadWeatherForecast(this);
        updateUI();
    }

