    private static String getWindFormat(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_UNITS, "m_per_second");
        if (unitsFromPreferences.contains("beaufort") ) {
            return "%.0f";
        } else {
            return "%.1f";
        }
    }

