    /**
     * @return Returns true if the app is started for the very first time else false.
     */
    public boolean isFirstAppStart() {
        boolean isFirstStart = preferences.getBoolean(PREFERENCES_IS_FIRST_START, true);
        if (isFirstStart) {
            setFirstAppStartToFalse();
        }
        return isFirstStart;
    }

