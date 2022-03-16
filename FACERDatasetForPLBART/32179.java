    public void onResume(){
        super.onResume();
        registerReceiver(mWeatherUpdateReceiver,
                new IntentFilter(ACTION_ADDRESS_RESOLUTION_RESULT));
        map.onResume();
    }

