    public static void setUpdateServiceAlarm(Context context, int updateFreq) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager manager = (AlarmManager)context.getSystemService(ALARM_SERVICE);
        if (updateFreq != 0) {
            manager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + updateFreq * ONE_HOUR, pendingIntent);
        } else {
            manager.cancel(pendingIntent);
            pendingIntent.cancel();
        }
    }

