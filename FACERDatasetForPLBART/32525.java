    private long getNextTimeForNotification(long currentAlarmWakeup, Calendar now, long lastUpdate, long updatePeriod, boolean updatedNow) {
        long nextUpdateForLocation;
        appendLog(getBaseContext(), TAG,
                "updatedNow=",
                updatedNow,
                ", updatePeriod=",
                updatePeriod);
        if (updatedNow || (updatePeriod == 0)) {
            nextUpdateForLocation = updatePeriod;
        } else {
            nextUpdateForLocation = (lastUpdate + updatePeriod) - now.getTimeInMillis();
        }
        if ((nextUpdateForLocation <= 0) || (currentAlarmWakeup < nextUpdateForLocation)) {
            return currentAlarmWakeup;
        }
        return nextUpdateForLocation;
    }

