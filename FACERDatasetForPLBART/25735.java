    @Override
    public void startPolling(Context context, long seconds, Class<?> cls, String action) {
        //èŽ·å?–AlarmManagerç³»ç»Ÿæœ?åŠ¡
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //è§¦å?‘æœ?åŠ¡çš„èµ·å§‹æ—¶é—´
        long triggerAtTime = SystemClock.elapsedRealtime();

        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, seconds * 1000, pendingIntent);
    }

