    private void updateTimeSequence() {
        setUpdateTimeAlarm(mContext, false, 0);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int updateFrequence = gregorianCalendar.get(GregorianCalendar.SECOND);
        updateFrequence *= ONE_SECOND;
        //LogUtil.e(TAG, "current second=" + updateFrequence);
        if (updateFrequence > 8 * ONE_SECOND && updateFrequence < 52 * ONE_SECOND) {
            updateFrequence = 5 * ONE_SECOND;
        } else {
            updateFrequence = ONE_SECOND >> 1;
        }

        //LogUtil.e(TAG, "updateSequence=" + updateFrequence);
        setUpdateTimeAlarm(mContext, true, updateFrequence);
    }

