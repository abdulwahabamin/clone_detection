    private static void setUpdateTimeAlarm(Context context, boolean on, final int updateSequency) {
        //LogUtil.e(TAG, "setUpdateTimeAlarm, on=" + on);

        Intent intent = new Intent(UPDATE_WIDGET_ACTION);
        intent.putExtra(UPDATE_TYPE, UPDATE_TIME);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if (on) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                //LogUtil.e(TAG, "setRepeating");
                manager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + updateSequency, updateSequency, pendingIntent);
            } else {
                //LogUtil.e(TAG, "setExact");
                manager.setExact(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + updateSequency, pendingIntent);
            }
        } else {
            manager.cancel(pendingIntent);
            pendingIntent.cancel();
        }
    }

