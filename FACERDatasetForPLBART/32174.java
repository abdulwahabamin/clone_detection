    @Override
    public void onReceive(Context context, Intent intent) {
        appendLog(context, TAG, "onReceive start");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().putStringSet(Constants.CONNECTED_BT_DEVICES, new HashSet<String>()).apply();
        removeOldPreferences(context);
        appendLog(context, TAG, "scheduleStart start");
        AppPreference.setLastSensorServicesCheckTimeInMs(context, 0);
        scheduleStart(context);
        appendLog(context, TAG, "scheduleStart end");
        Intent intentToStartUpdate = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
        context.startService(intentToStartUpdate);
        TimeUtils.setupAlarmForVoice(context);
    }

