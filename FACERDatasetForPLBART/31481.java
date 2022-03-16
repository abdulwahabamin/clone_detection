    @Override
    protected void onResume() {
        super.onResume();
        //smLocalBroadcastManager.registerReceiver(mWeatherUpdateReceiver, new IntentFilter(WEATHER_UPDATE_ACTION));
        registerReceiver(mWeatherUpdateReceiver, new IntentFilter(WEATHER_UPDATE_ACTION), Constants.SEND_WEATHER_UPDATE, null);
    }

