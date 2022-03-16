    /**
     * Obtains the temperature scale from the shared preferences.
     *
     * @return the temperature scale preferred by the user
     */
    TemperatureScale getTemperatureScale() {
        String temperatureScaleIdString = PreferenceManager
                .getDefaultSharedPreferences(context).getString(
                        SettingsActivity.PREF_TEMPERATURE_SCALE, context.getResources().getString(
                                R.string.pref_temperature_scale_id_default));
        int temperatureScaleId = Integer.parseInt(temperatureScaleIdString);
        return TemperatureScale.getTemperatureScaleById(temperatureScaleId);
    }

