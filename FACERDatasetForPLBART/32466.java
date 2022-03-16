    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        if (intent == null) {
            return ret;
        }
        appendLog(getBaseContext(), TAG, "onStartCommand:intent.getAction():", intent.getAction());
        switch (intent.getAction()) {
            case "android.intent.action.START_SCREEN_BASED_UPDATES": startSensorBasedUpdates(); return START_STICKY;
            case "android.intent.action.STOP_SCREEN_BASED_UPDATES": stopSensorBasedUpdates(); return ret;
            default: return ret;
        }
    }

