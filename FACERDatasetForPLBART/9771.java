    /**
     * Schedule a cleanup alarm
     *
     * @param context {@link android.content.Context}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public static void scheduleCleanup(Context context) throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, SecureCacheCleanupService.class);
        intent.setAction(ACTION_START);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, 1000,
                AlarmManager.INTERVAL_HOUR, pendingIntent);
    }

