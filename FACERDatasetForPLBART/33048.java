    @Override
    protected void preLoadWeather(Context context, RemoteViews remoteViews, int appWidgetId) {
        appendLog(context, TAG, "preLoadWeather:start");
        final CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(context);
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);

        Long locationId = widgetSettingsDbHelper.getParamLong(appWidgetId, "locationId");

        if (locationId == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
            if (!currentLocation.isEnabled()) {
                currentLocation = locationsDbHelper.getLocationByOrderId(1);
            }
        } else {
            currentLocation = locationsDbHelper.getLocationById(locationId);
        }

        if (currentLocation == null) {
            return;
        }

        CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(currentLocation.getId());

        WidgetUtils.updateCurrentWeatherDetails(
                context,
                remoteViews,
                weatherRecord,
                currentLocation.getLocale(),
                appWidgetId,
                DEFAULT_CURRENT_WEATHER_DETAILS);

        appendLog(context, TAG, "Updating weather in widget, currentLocation.id=" + currentLocation.getId() + ", weatherRecord=" + weatherRecord);

        if (weatherRecord != null) {
            Weather weather = weatherRecord.getWeather();

            remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_city, Utils.getCityAndCountry(context, currentLocation.getOrderId()));
            remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_temperature, TemperatureUtil.getTemperatureWithUnit(
                    context,
                    weather,
                    currentLocation.getLatitude(),
                    weatherRecord.getLastUpdatedTime(),
                    currentLocation.getLocale()));
            String secondTemperature = TemperatureUtil.getSecondTemperatureWithUnit(
                    context,
                    weather,
                    currentLocation.getLatitude(),
                    weatherRecord.getLastUpdatedTime(),
                    currentLocation.getLocale());
            if (secondTemperature != null) {
                remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_3x3_widget_second_temperature, View.VISIBLE);
                remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_second_temperature, secondTemperature);
            } else {
                remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_3x3_widget_second_temperature, View.GONE);
            }
            remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_description,
                                        Utils.getWeatherDescription(context,
                                                                    currentLocation.getLocaleAbbrev(),
                                                                    weather));

            Utils.setWeatherIcon(remoteViews, context, weatherRecord,
                    R.id.widget_ext_loc_forecast_3x3_widget_icon);
        } else {
            remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_city, context.getString(R.string.location_not_found));
            remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_temperature, TemperatureUtil.getTemperatureWithUnit(
                    context,
                    null,
                    currentLocation.getLatitude(),
                    0,
                    currentLocation.getLocale()));
            String secondTemperature = TemperatureUtil.getSecondTemperatureWithUnit(
                    context,
                    null,
                    currentLocation.getLatitude(),
                    0,
                    currentLocation.getLocale());
            if (secondTemperature != null) {
                remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_3x3_widget_second_temperature, View.VISIBLE);
                remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_second_temperature, secondTemperature);
            } else {
                remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_3x3_widget_second_temperature, View.GONE);
            }
            remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_description, "");

            Utils.setWeatherIcon(remoteViews, context, weatherRecord,
                    R.id.widget_ext_loc_forecast_3x3_widget_icon);
        }
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = null;
        try {
            weatherForecastRecord = WidgetUtils.updateWeatherForecast(
                    context,
                    currentLocation.getId(),
                    appWidgetId,
                    remoteViews,
                    R.id.widget_ext_loc_forecast_3x3_forecast_day_1,
                    R.id.widget_ext_loc_forecast_3x3_forecast_1_widget_icon,
                    R.id.widget_ext_loc_forecast_3x3_forecast_1_widget_day,
                    R.id.widget_ext_loc_forecast_3x3_forecast_1_widget_temperatures,
                    R.id.widget_ext_loc_forecast_3x3_forecast_day_2,
                    R.id.widget_ext_loc_forecast_3x3_forecast_2_widget_icon,
                    R.id.widget_ext_loc_forecast_3x3_forecast_2_widget_day,
                    R.id.widget_ext_loc_forecast_3x3_forecast_2_widget_temperatures,
                    R.id.widget_ext_loc_forecast_3x3_forecast_day_3,
                    R.id.widget_ext_loc_forecast_3x3_forecast_3_widget_icon,
                    R.id.widget_ext_loc_forecast_3x3_forecast_3_widget_day,
                    R.id.widget_ext_loc_forecast_3x3_forecast_3_widget_temperatures,
                    R.id.widget_ext_loc_forecast_3x3_forecast_day_4,
                    R.id.widget_ext_loc_forecast_3x3_forecast_4_widget_icon,
                    R.id.widget_ext_loc_forecast_3x3_forecast_4_widget_day,
                    R.id.widget_ext_loc_forecast_3x3_forecast_4_widget_temperatures,
                    R.id.widget_ext_loc_forecast_3x3_forecast_day_5,
                    R.id.widget_ext_loc_forecast_3x3_forecast_5_widget_icon,
                    R.id.widget_ext_loc_forecast_3x3_forecast_5_widget_day,
                    R.id.widget_ext_loc_forecast_3x3_forecast_5_widget_temperatures);
        } catch (Exception e) {
            appendLog(context, TAG, "preLoadWeather:error updating weather forecast", e);
        }
        String lastUpdate = Utils.getLastUpdateTime(context, weatherRecord, weatherForecastRecord, currentLocation);
        remoteViews.setTextViewText(R.id.widget_ext_loc_forecast_3x3_widget_last_update, lastUpdate);
        appendLog(context, TAG, "preLoadWeather:end");
    }

