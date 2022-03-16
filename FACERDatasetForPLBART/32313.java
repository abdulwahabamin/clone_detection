    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        appendLog(getBaseContext(), TAG, "onStartCommand:", intent);
        if (intent == null) {
            return ret;
        }
        boolean forceUpdate = false;
        Long locationId = null;
        String updateSource = null;
        boolean updateWeatherOnly = false;
        if (intent.hasExtra("forceUpdate")) {
            forceUpdate = intent.getBooleanExtra("forceUpdate", false);
        }
        if (intent.hasExtra("locationId")) {
            locationId = intent.getLongExtra("locationId", 0);
        }
        if (intent.hasExtra("updateSource")) {
            updateSource = intent.getStringExtra("updateSource");
        }
        if (intent.hasExtra("updateWeatherOnly")) {
            updateWeatherOnly = intent.getBooleanExtra("updateWeatherOnly", false);
        }
        currentWeatherUpdateMessages.add(new WeatherRequestDataHolder(locationId, updateSource, forceUpdate, updateWeatherOnly));
        startCurrentWeatherUpdate(0);
        return ret;
    }

