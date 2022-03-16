    public static String getUpdateSource(Context context, String locationSource) {
        String updateDetailLevel = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_UPDATE_DETAIL, "preference_display_update_nothing");
        switch (updateDetailLevel) {
            case "preference_display_update_value":
            case "preference_display_update_location_source":
                return locationSource;
            case "preference_display_update_nothing":
            default:
                return "";
        }
    }

