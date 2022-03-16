    /**
     * Obtains the wind speed measurement units from the shared preferences.
     *
     * @return the wind speed measurement units preferred by a user
     */
    private WindSpeedMeasurementUnit getWindSpeedMeasurementUnit() {
        String windSpeedMeasurementUnitIdString = PreferenceManager
                .getDefaultSharedPreferences(context).getString(
                        SettingsActivity.PREF_WIND_SPEED_MEASUREMENT_UNIT,
                        context.getResources().getString(R.string.pref_wind_speed_unit_id_default));
        int windSpeedMeasurementUnitId = Integer.parseInt(windSpeedMeasurementUnitIdString);
        return WindSpeedMeasurementUnit.getWindSpeedMeasurementUnitById(windSpeedMeasurementUnitId);
    }

