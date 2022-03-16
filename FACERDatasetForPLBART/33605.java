    /**
     * Determines if cities are deleted using button.
     */
    public static boolean isRemovalModeButton(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Resources res = context.getResources();
        String cityRemovalModeIdString = preferences.getString(SettingsActivity.
                        PREF_CITY_REMOVAL_MODE,
                res.getString(R.string.pref_city_removal_mode_id_default));
        return cityRemovalModeIdString.equals(res.getString(
                R.string.pref_city_removal_mode_button_id));
    }

