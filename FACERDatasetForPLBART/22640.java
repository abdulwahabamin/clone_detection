    /**
     * @parm lastAddedMillis timestamp in millis used as a cutoff for last added playlist
     */
    public void setLastAddedCutoff(long lastAddedMillis) {
        mPreferences.edit().putLong(LAST_ADDED_CUTOFF, lastAddedMillis).apply();
    }

