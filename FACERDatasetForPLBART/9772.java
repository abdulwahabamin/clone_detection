    /**
     * Cancel a cleanup alarm
     *
     * @param context {@link android.content.Context}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public static void cancelAlarm(Context context) throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, SecureCacheCleanupService.class);
        intent.setAction(ACTION_START);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        alarmManager.cancel(pendingIntent);
    }

