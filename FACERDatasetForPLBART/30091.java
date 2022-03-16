    public void setAlarm() {
        long updatePeriodMills = Long.parseLong(new Prefs(mContext).getTime());
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + updatePeriodMills,
                updatePeriodMills,
                getPendingIntent(mCls));
    }

