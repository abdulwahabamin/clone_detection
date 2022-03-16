    private void checkVersionOfStoredForecastInDb() {

        int initialGuideVersion = PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(Constants.APP_INITIAL_GUIDE_VERSION, 0);
        if (initialGuideVersion != 1) {
            return;
        }
        appendLog(context, TAG, "Old version of stored forecast, clearing forecast DB");
        SQLiteDatabase db = getWritableDatabase();
        onUpgrade(db, 0, 1);
        SharedPreferences.Editor preferences = PreferenceManager.getDefaultSharedPreferences(context).edit();
        preferences.putInt(Constants.APP_INITIAL_GUIDE_VERSION, 2);
        preferences.apply();
    }

