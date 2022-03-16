    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mWeatherUpdateReceiver,
                new IntentFilter(
                        ForecastWeatherService.ACTION_FORECAST_UPDATE_RESULT));
        updateUI();
    }

