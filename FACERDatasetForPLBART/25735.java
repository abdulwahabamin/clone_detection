    @Override
    public void startPolling(Context context, long seconds, Class<?> cls, String action) {
        //获�?�AlarmManager系统�?务
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //触�?��?务的起始时间
        long triggerAtTime = SystemClock.elapsedRealtime();

        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, seconds * 1000, pendingIntent);
    }

