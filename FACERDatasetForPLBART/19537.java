    /**
     * Returns the current repeat mode. The repeat mode 
     * is determined based on the value that is saved in 
     * SharedPreferences.
     */
    public int getRepeatMode() {
    	return mApp.getSharedPreferences().getInt(Common.REPEAT_MODE, Common.REPEAT_OFF);
    }

