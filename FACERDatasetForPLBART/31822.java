    @Override
    public void onResume() {
        super.onResume();
        updateCurrentLocationAndButtonVisibility();
        checkSettingsAndPermisions();
        updateUI();
        mAppBarLayout.addOnOffsetChangedListener(this);
        registerReceiver(mWeatherUpdateReceiver,
                new IntentFilter(
                        CurrentWeatherService.ACTION_WEATHER_UPDATE_RESULT));
    }

