    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        appendLog(getBaseContext(), TAG, "onStartCommand:", intent);

        if (intent == null) {
            return ret;
        }
        switch (intent.getAction()) {
            case "android.intent.action.START_WEATHER_NOTIFICATION_UPDATE": startWeatherCheck(); scheduleNextNotificationAlarm(); return ret;
            default: return ret;
        }
    }

