    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        CheckConnection checkNetwork = new CheckConnection(this);
        if (!checkNetwork.isNetworkAvailable()) {
            return;
        }

        Log.i("In" , "Notification Service Alarm");
        intent = NotificationService.newIntent(this);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        prefs = new Prefs(this);
        long intervalMillis = Long.parseLong(prefs.getTime());
        if (alarmManager != null)
            if (new Prefs(this).getNotifs()) {
                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        SystemClock.elapsedRealtime(),
                        intervalMillis,
                        pendingIntent);
            } else {
                alarmManager.cancel(pendingIntent);
                pendingIntent.cancel();
            }

        String city = prefs.getCity();
        String units = PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC);

        try {
            WeatherInfo weather;
            weather = new Request(this).getItems(city, units);
            if (new Prefs(this).getNotifs())
                weatherNotification(weather);
        } catch (IOException e) {
            Log.e(TAG, "Error get weather", e);
        }
    }

