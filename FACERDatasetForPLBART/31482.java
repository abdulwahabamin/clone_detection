    @Override
    protected void onPause() {
        super.onPause();
        //mLocalBroadcastManager.unregisterReceiver(mWeatherUpdateReceiver);
        unregisterReceiver(mWeatherUpdateReceiver);
    }

