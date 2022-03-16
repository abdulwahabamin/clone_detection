    /**
     * Indicates if shuffle mode is turned on or off.
     */
    public boolean isShuffleOn() {
    	return mApp.getSharedPreferences().getBoolean(Common.SHUFFLE_ON, false);
    }

