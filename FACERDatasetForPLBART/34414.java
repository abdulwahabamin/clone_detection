    public void setAlarm() {
        String updatePeriodStr = AppPreference.getWidgetUpdatePeriod(mContext);
        long updatePeriodMills = Utils.intervalMillisForAlarm(updatePeriodStr);
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                                         SystemClock.elapsedRealtime() + updatePeriodMills,
                                         updatePeriodMills,
                                         getPendingIntent(mCls));
    }

