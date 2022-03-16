    private boolean recordDateIsNotValidOrIsTooOld(long recordCreatedinMilis) {
        Calendar now = Calendar.getInstance();
        Calendar calendarRecordCreated = Calendar.getInstance();
        calendarRecordCreated.setTimeInMillis(recordCreatedinMilis);

        int timeToLiveRecordsInCacheInHours = 8760;/*Integer.parseInt(
                PreferenceManager.getDefaultSharedPreferences(this).getString(SettingsActivity.LOCATION_CACHE_LASTING_HOURS, "720"))*/;

        calendarRecordCreated.add(Calendar.HOUR_OF_DAY, timeToLiveRecordsInCacheInHours);
        return calendarRecordCreated.before(now);
    }

