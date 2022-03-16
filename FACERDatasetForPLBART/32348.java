    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        if (intent == null) {
            return ret;
        }
        forceUpdate = false;
        updateSource = null;
        appendLog(getBaseContext(), TAG, "onStartCommand:intent.getAction():", intent.getAction());
        switch (intent.getAction()) {
            case "android.intent.action.START_LOCATION_AND_WEATHER_UPDATE": startLocationAndWeatherUpdate(intent); return ret;
            case "android.intent.action.START_LOCATION_ONLY_UPDATE": updateNetworkLocation(intent); return ret;
            default: return ret;
        }
    }

