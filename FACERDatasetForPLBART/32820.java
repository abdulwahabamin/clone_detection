    private static void checkPreferences(Context context) {
        if (nextCheckPreferencesCheck != null) {
            Calendar now = Calendar.getInstance();
            if (nextCheckPreferencesCheck.after(now)) {
                return;
            }
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        if (logToFileEnabled == null) {
            logFilePathname = sharedPreferences.getString(SettingsActivity.KEY_DEBUG_FILE,"");
            logToFileEnabled = sharedPreferences.getBoolean(SettingsActivity.KEY_DEBUG_TO_FILE, false);
            logFileHoursOfLasting = Integer.valueOf(sharedPreferences.getString(SettingsActivity.KEY_DEBUG_FILE_LASTING_HOURS, "24"));
        }
        nextCheckPreferencesCheck = Calendar.getInstance();
        nextCheckPreferencesCheck.add(Calendar.MINUTE, 5);
    }

