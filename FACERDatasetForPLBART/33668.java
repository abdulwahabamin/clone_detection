    /**
     * Displays wind speed and direction.
     *
     * @param weatherInformation various parameters describing weather
     * @param windTextView       view to display wind information
     */
    void displayWindInfo(WeatherInformation weatherInformation, final TextView windTextView) {
        Wind wind = weatherInformation.getWind();
        // It seems that wind information is not always provided by OWM
        if (wind == null) {
            return;
        }
        WindSpeedMeasurementUnit windSpeedMeasurementUnit = getWindSpeedMeasurementUnit();

        String windInfo = res.getString(R.string.weather_info_wind_speed) + SEPARATOR;
        if (windSpeedMeasurementUnit == WindSpeedMeasurementUnit.BEAUFORT_SCALE) {
            windInfo += res.getString(R.string.weather_info_wind_speed_beaufort_scale_force);
            long windForce = Math.round(wind.getSpeed(windSpeedMeasurementUnit));
            windInfo += " " + windForce + " (";
            String beaufortScaleDescription = res.getString(WindSpeedMeasurementUnit
                    .getBeaufortScaleWindDescriptionStringResourceId((int) windForce));
            windInfo += beaufortScaleDescription.substring(0, 1).toUpperCase() +
                    beaufortScaleDescription.substring(1);
            windInfo += ")";
        } else {
            windInfo += MiscMethods.formatDoubleValue(wind.getSpeed(windSpeedMeasurementUnit), 1)
                    + " " + res.getString(windSpeedMeasurementUnit.getDisplayResourceId());
        }

        if (PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(SettingsActivity.PREF_WIND_DIRECTION_DISPLAY, true)) {
            windInfo += "\n" + res.getString(R.string.weather_info_wind_direction) + SEPARATOR +
                    wind.getDirectionInDegrees() + res.getString(R.string.weather_info_degree);
            windInfo += "\n(" + res.getString(wind.getCardinalDirectionStringResource()) + ")";
        }

        windTextView.setText(windInfo);
    }

