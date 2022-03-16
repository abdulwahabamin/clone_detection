    public static boolean is12TimeStyle(Context context) {
        String timeStylePreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TIME_STYLE, "system");
        if ("system".equals(timeStylePreferences)) {
            return !DateFormat.is24HourFormat(context);
        } else if ("12h".equals(timeStylePreferences)) {
            return true;
        } else {
            return false;
        }
    }

