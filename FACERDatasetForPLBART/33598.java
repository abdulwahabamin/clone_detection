    /**
     * Saves the specified city ID.
     *
     * @param cityId OpenWeatherMap city ID
     * @param commit commit if true, apply if false
     */
    public static void putCityIdIntoSharedPrefs(Context context, int cityId, boolean commit) {
        SharedPreferences.Editor editor = getEditor(context).putInt(LAST_SELECTED_CITY_ID, cityId);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

