    private void updateTimeSequence() {
        setUpdateTimeAlarm(mContext, false, 0);

        int updateFrequence = 0;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int currentHour = gregorianCalendar.get(GregorianCalendar.HOUR_OF_DAY);
        int currentMinute = gregorianCalendar.get(GregorianCalendar.MINUTE);
        LogUtil.e(TAG, "current hour=" + currentHour);
        LogUtil.e(TAG, "current minute=" + currentMinute);
        if (currentHour == 23 || currentHour == 0) {
            if ((currentMinute > 40 && currentHour == 23) || (currentMinute < 20 && currentHour == 0))
                updateFrequence = ONE_MINUTE;
            else
                updateFrequence = 10 * ONE_MINUTE;
        } else {
            updateFrequence = ONE_HOUR;
        }

        LogUtil.e(TAG, "updateSequence=" + updateFrequence);
        setUpdateTimeAlarm(mContext, true, updateFrequence);
    }

