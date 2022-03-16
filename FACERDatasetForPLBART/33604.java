    /**
     * Obtains the three-hourly forecast display mode from the shared preferences.
     *
     * @return weather forecast display mode preferred by the user, such as a list, or a horizontal
     * swipe view
     */
    public static ThreeHourlyForecastDisplayMode getForecastDisplayMode(Context context) {
        String forecastDisplayModeIdString = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(SettingsActivity.PREF_FORECAST_DISPLAY_MODE, context.getResources()
                        .getString(R.string.pref_forecast_display_mode_id_default));
        int forecastDisplayModeId = Integer.parseInt(forecastDisplayModeIdString);
        return ThreeHourlyForecastDisplayMode.getForecastDisplayModeById(forecastDisplayModeId);
    }

