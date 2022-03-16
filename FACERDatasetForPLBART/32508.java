    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        if (intent == null) {
            return ret;
        }
        appendLog(getBaseContext(), TAG, "onStartCommand:intent.getAction():", intent.getAction());
        switch (intent.getAction()) {
            case "android.intent.action.START_SENSOR_BASED_UPDATES": return performSensorBasedUpdates(ret);
            case "android.intent.action.STOP_SENSOR_BASED_UPDATES": stopSensorBasedUpdates(); return ret;
            case "android.intent.action.CLEAR_SENSOR_VALUES": clearMeasuredLength(); return ret;
        }
        return START_STICKY;
    }

