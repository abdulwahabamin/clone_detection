    protected void startReconciliation(boolean force) {
        appendLog(this, TAG, "onHandleIntent");
        long nowInMilis = System.currentTimeMillis();
        timerHandler.removeCallbacksAndMessages(null);
        if (!force) {
            if (nextReconciliationTime == 0) {
                nextReconciliationTime = nowInMilis + MIN_RECONCILIATION_TIME_SPAN_IN_MS;
                appendLog(
                        this,
                        TAG,
                        "nextReconciliationTime is 0");
            } else if (nextReconciliationTime > nowInMilis) {
                appendLog(
                        this,
                        TAG,
                        "rescheduling with inMilis:", nextReconciliationTime, ":", nowInMilis);
                timerHandler.postDelayed(timerRunnable, MIN_RECONCILIATION_TIME_SPAN_IN_MS);
                return;
            }
        }
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getApplicationContext());
        LocationsFileDbHelper locationsFileDbHelper = LocationsFileDbHelper.getInstance(getApplicationContext());
        SQLiteDatabase db = locationsFileDbHelper.getWritableDatabase();
        for (Location location: locationsDbHelper.getAllRows()) {
            Location locationInFile = locationsFileDbHelper.getLocationById(location.getId());
            if (locationInFile == null) {
                insertLocation(db, location);
            } else {
                updateLocation(db, location, locationInFile);
            }
        }
        for (Location location: locationsFileDbHelper.getAllRows()) {
            Location locationInRam = locationsDbHelper.getLocationById(location.getId());
            if (locationInRam == null) {
                locationsFileDbHelper.deleteRecordFromTable(location);
            }
        }
        nextReconciliationTime = System.currentTimeMillis() + MIN_RECONCILIATION_TIME_SPAN_IN_MS;
    }

