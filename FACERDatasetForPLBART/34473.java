    private void preLoadWeather(Context context, RemoteViews remoteViews) {
        SharedPreferences weatherPref = context.getSharedPreferences(Constants.PREF_WEATHER_NAME,
                                                                     Context.MODE_PRIVATE);
        String temperatureScale = Utils.getTemperatureScale(context);
        String speedScale = Utils.getSpeedScale(context);
        String percentSign = context.getString(R.string.percent_sign);
        String pressureMeasurement = context.getString(R.string.pressure_measurement);

        String temperature = String.format(Locale.getDefault(), "%.0f", weatherPref
                .getFloat(Constants.WEATHER_DATA_TEMPERATURE, 0));
        String description = weatherPref.getString(Constants.WEATHER_DATA_DESCRIPTION, "clear sky");
        String wind = context.getString(R.string.wind_label,
                                        String.format(Locale.getDefault(), "%.0f", weatherPref
                                                .getFloat(Constants.WEATHER_DATA_WIND_SPEED, 0)),
                                        speedScale);
        String humidity =
                context.getString(R.string.humidity_label,
                                  String.valueOf(
                                          weatherPref.getInt(Constants.WEATHER_DATA_HUMIDITY, 0)),
                                  percentSign);
        String pressure =
                context.getString(R.string.pressure_label,
                                  String.format(Locale.getDefault(),
                                                "%.1f",
                                                weatherPref
                                                        .getFloat(Constants.WEATHER_DATA_PRESSURE,
                                                                  0)),
                                  pressureMeasurement);
        String cloudiness =
                context.getString(R.string.cloudiness_label,
                                  String.valueOf(
                                          weatherPref.getInt(Constants.WEATHER_DATA_CLOUDS, 0)),
                                  percentSign);
        String iconId = weatherPref.getString(Constants.WEATHER_DATA_ICON, "01d");
        String weatherIcon = Utils.getStrIcon(context, iconId);
        String lastUpdate = Utils.setLastUpdateTime(context,
                                                    AppPreference.getLastUpdateTimeMillis(context));

        remoteViews.setTextViewText(R.id.widget_city, Utils.getCityAndCountry(context));
        remoteViews.setTextViewText(R.id.widget_temperature, temperature + temperatureScale);
        if(!AppPreference.hideDescription(context))
            remoteViews.setTextViewText(R.id.widget_description, description);
        else remoteViews.setTextViewText(R.id.widget_description, " ");
        remoteViews.setTextViewText(R.id.widget_wind, wind);
        remoteViews.setTextViewText(R.id.widget_humidity, humidity);
        remoteViews.setTextViewText(R.id.widget_pressure, pressure);
        remoteViews.setTextViewText(R.id.widget_clouds, cloudiness);
        remoteViews.setImageViewBitmap(R.id.widget_icon,
                                       Utils.createWeatherIcon(context, weatherIcon));
        remoteViews.setTextViewText(R.id.widget_last_update, lastUpdate);
    }

