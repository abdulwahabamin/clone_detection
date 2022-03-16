    @Override
    protected void preLoadWeather(Context context, RemoteViews remoteViews, int appWidgetId) {
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

        if (weatherRecord != null) {
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_temperature, TemperatureUtil.getTemperatureWithUnit(
                    context,
                    weatherRecord.getWeather(),
                    currentLocation.getLatitude(),
                    weatherRecord.getLastUpdatedTime(),
                    currentLocation.getLocale()));
            String secondTemperature = TemperatureUtil.getSecondTemperatureWithUnit(
                    context,
                    weatherRecord.getWeather(),
                    currentLocation.getLatitude(),
                    weatherRecord.getLastUpdatedTime(),
                    currentLocation.getLocale());
            if (secondTemperature != null) {
                remoteViews.setViewVisibility(R.id.widget_less_3x1_widget_second_temperature, View.VISIBLE);
                remoteViews.setTextViewText(R.id.widget_less_3x1_widget_second_temperature, secondTemperature);
            } else {
                remoteViews.setViewVisibility(R.id.widget_less_3x1_widget_second_temperature, View.GONE);
            }
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_city, Utils.getCityAndCountry(context, currentLocation.getOrderId()));
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_description,
                                        Utils.getWeatherDescription(context,
                                                                    currentLocation.getLocaleAbbrev(),
                                                                    weatherRecord.getWeather()));
            Utils.setWeatherIcon(remoteViews, context, weatherRecord,
                    R.id.widget_less_3x1_widget_icon);
            String lastUpdate = Utils.getLastUpdateTime(context, weatherRecord, currentLocation);
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_last_update, lastUpdate);
        } else {
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_temperature, TemperatureUtil.getTemperatureWithUnit(
                    context,
                    null,
                    currentLocation.getLatitude(),
                    0,
                    currentLocation.getLocale()));
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_second_temperature, TemperatureUtil.getTemperatureWithUnit(
                    context,
                    null,
                    currentLocation.getLatitude(),
                    0,
                    currentLocation.getLocale()));
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_description, "");

            Utils.setWeatherIcon(remoteViews, context, weatherRecord, R.id.widget_less_3x1_widget_icon);
            remoteViews.setTextViewText(R.id.widget_less_3x1_widget_last_update, "");
        }
    }

