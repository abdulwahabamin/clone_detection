    public static void updateCurrentWeatherDetails(
            Context context,
            RemoteViews remoteViews,
            CurrentWeatherDbHelper.WeatherRecord weatherRecord,
            Locale locale,
            int widgetId,
            String defaultCurrentWeatherDetailValues) {

        int textColorId = AppPreference.getTextColor(context);

        remoteViews.setTextColor(R.id.widget_current_detail_wind, textColorId);
        remoteViews.setTextColor(R.id.widget_current_detail_humidity, textColorId);
        remoteViews.setTextColor(R.id.widget_current_detail_dew_point, textColorId);
        remoteViews.setTextColor(R.id.widget_current_detail_sunrise, textColorId);
        remoteViews.setTextColor(R.id.widget_current_detail_sunset, textColorId);
        remoteViews.setTextColor(R.id.widget_current_detail_pressure, textColorId);
        remoteViews.setTextColor(R.id.widget_current_detail_clouds, textColorId);

        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        Set<Integer> currentWeatherDetailValues = WidgetUtils.getCurrentWeatherDetailsFromSettings(
                widgetSettingsDbHelper,
                widgetId,
                defaultCurrentWeatherDetailValues);

        if (weatherRecord == null) {
            WidgetUtils.setWind(context,
                    remoteViews,
                    0,
                    0,
                    locale,
                    R.id.widget_current_detail_wind,
                    R.id.widget_current_detail_wind_icon,
                    currentWeatherDetailValues);
            WidgetUtils.setHumidity(context, remoteViews, 0,
                    R.id.widget_current_detail_humidity,
                    R.id.widget_current_detail_humidity_icon,
                    currentWeatherDetailValues);
            WidgetUtils.setDewPoint(context, remoteViews, null, locale,
                    R.id.widget_current_detail_dew_point,
                    R.id.widget_current_detail_dew_point_icon,
                    currentWeatherDetailValues);

            WidgetUtils.setSunrise(context,
                    remoteViews,
                    null,
                    locale,
                    R.id.widget_current_detail_sunrise,
                    R.id.widget_current_detail_sunrise_icon,
                    currentWeatherDetailValues);
            WidgetUtils.setSunset(context,
                    remoteViews,
                    null,
                    locale,
                    R.id.widget_current_detail_sunset,
                    R.id.widget_current_detail_sunset_icon,
                    currentWeatherDetailValues);

            WidgetUtils.setPressure(context,
                    remoteViews,
                    0,
                    locale,
                    R.id.widget_current_detail_pressure,
                    R.id.widget_current_detail_pressure_icon,
                    currentWeatherDetailValues);
            WidgetUtils.setClouds(context, remoteViews, 0,
                    R.id.widget_current_detail_clouds,
                    R.id.widget_current_detail_clouds_icon,
                    currentWeatherDetailValues);
            return;
        }

        Weather weather = weatherRecord.getWeather();

        WidgetUtils.setWind(context,
                remoteViews,
                weather.getWindSpeed(),
                weather.getWindDirection(),
                locale,
                R.id.widget_current_detail_wind,
                R.id.widget_current_detail_wind_icon,
                currentWeatherDetailValues);
        WidgetUtils.setHumidity(context, remoteViews, weather.getHumidity(),
                R.id.widget_current_detail_humidity,
                R.id.widget_current_detail_humidity_icon,
                currentWeatherDetailValues);
        WidgetUtils.setDewPoint(context,
                remoteViews,
                weather,
                locale,
                R.id.widget_current_detail_dew_point,
                R.id.widget_current_detail_dew_point_icon,
                currentWeatherDetailValues);

        WidgetUtils.setPressure(context,
                remoteViews,
                weather.getPressure(),
                locale,
                R.id.widget_current_detail_pressure,
                R.id.widget_current_detail_pressure_icon,
                currentWeatherDetailValues);
        WidgetUtils.setClouds(context, remoteViews, weather.getClouds(),
                R.id.widget_current_detail_clouds,
                R.id.widget_current_detail_clouds_icon,
                currentWeatherDetailValues);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * weather.getSunrise());
        WidgetUtils.setSunrise(context,
                remoteViews,
                calendar,
                locale,
                R.id.widget_current_detail_sunrise,
                R.id.widget_current_detail_sunrise_icon,
                currentWeatherDetailValues);
        calendar.setTimeInMillis(1000 * weather.getSunset());
        WidgetUtils.setSunset(context,
                remoteViews,
                calendar,
                locale,
                R.id.widget_current_detail_sunset,
                R.id.widget_current_detail_sunset_icon,
                currentWeatherDetailValues);
    }

