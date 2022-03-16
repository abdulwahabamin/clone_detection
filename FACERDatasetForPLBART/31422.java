    private static void setUpdateTimeAlarm(Context context, boolean on, final int updateSequency) {
        LogUtil.e(TAG, "setUpdateTimeAlarm, on=" + on);

        Intent intent = new Intent(context, WeatherNotificationService.class);
        intent.putExtra(UPDATE_TYPE, UPDATE_TIME);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if (on) {
            manager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + updateSequency, updateSequency, pendingIntent);
        } else {
            manager.cancel(pendingIntent);
            pendingIntent.cancel();
        }
    }

