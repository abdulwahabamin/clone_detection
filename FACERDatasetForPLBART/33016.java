    protected void startServiceWithCheck(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (IllegalStateException ise) {
            intent.putExtra("isInteractive", false);
            PendingIntent pendingIntent = PendingIntent.getService(context,
                    0,
                    intent,
                    PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + 10,
                    pendingIntent);
        }
    }

