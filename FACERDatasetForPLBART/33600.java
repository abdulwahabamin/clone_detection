    /**
     * Obtains the {@link WeatherInfoType} for the last user's query.
     */
    public static WeatherInfoType getLastWeatherInfoTypeFromSharedPrefs(Context context) {
        int lastSelectedWeatherInfoTypeId = getSharedPreferences(context).getInt(
                LAST_SELECTED_WEATHER_INFO_TYPE, WeatherInfoType.CURRENT_WEATHER.getId());
        return WeatherInfoType.getTypeById(lastSelectedWeatherInfoTypeId);
    }

