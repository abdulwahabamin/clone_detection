    /**
     * Method that returns the shared preferences of the application.
     *
     * @return SharedPreferences The shared preferences of the application
     * @hide
     */
    public static SharedPreferences getSharedPreferences() {
        return FileManagerApplication.getInstance().getSharedPreferences(
                SETTINGS_FILENAME, Context.MODE_PRIVATE);
    }

