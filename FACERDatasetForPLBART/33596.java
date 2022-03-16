    /**
     * Obtains the ID of the city that was last queried by the user.
     */
    public static int getCityIdFromSharedPrefs(Context context) {
        return getSharedPreferences(context).getInt(LAST_SELECTED_CITY_ID,
                CityTable.CITY_ID_DOES_NOT_EXIST);
    }

