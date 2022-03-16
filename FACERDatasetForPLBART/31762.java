    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mWeatherUpdateReceiver,
                new IntentFilter(
                        ForecastWeatherService.ACTION_GRAPHS_UPDATE_RESULT));
        updateUI();
    }

