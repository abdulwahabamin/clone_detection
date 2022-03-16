    /**
     * Saves the {@link WeatherInfoType} that was last queried by the user.
     *
     * @param weatherInfoType a kind of weather information
     */
    public static void putLastWeatherInfoTypeIntoSharedPrefs(Context context,
                                                             WeatherInfoType weatherInfoType) {
        getEditor(context).putInt(LAST_SELECTED_WEATHER_INFO_TYPE, weatherInfoType.getId()).apply();
    }

