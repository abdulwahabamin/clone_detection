    private static WeatherForecastDbHelper.WeatherForecastRecord createForecastByHours(
            Context context,
            Location location,
            int fontColorId,
            WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord,
            long hoursCount,
            RemoteViews remoteViews,
            Integer forecast_1_widget_day_layout,
            int forecast_1_widget_icon,
            int forecast_1_widget_day,
            int forecast_1_widget_temperatures,
            Integer forecast_2_widget_day_layout,
            int forecast_2_widget_icon,
            int forecast_2_widget_day,
            int forecast_2_widget_temperatures,
            Integer forecast_3_widget_day_layout,
            int forecast_3_widget_icon,
            int forecast_3_widget_day,
            int forecast_3_widget_temperatures,
            Integer forecast_4_widget_day_layout,
            int forecast_4_widget_icon,
            int forecast_4_widget_day,
            int forecast_4_widget_temperatures,
            Integer forecast_5_widget_day_layout,
            int forecast_5_widget_icon,
            int forecast_5_widget_day,
            int forecast_5_widget_temperatures) {

        int hourCounter = 0;
        for (DetailedWeatherForecast detailedWeatherForecast: weatherForecastRecord.getCompleteWeatherForecast().getWeatherForecastList()) {
            switch (++hourCounter) {
                case 1:
                    setForecastHourInfo(
                            context,
                            fontColorId,
                            hourCounter,
                            hoursCount,
                            remoteViews,
                            forecast_1_widget_day_layout,
                            forecast_1_widget_icon,
                            detailedWeatherForecast.getFirstWeatherCondition().getWeatherId(),
                            forecast_1_widget_day,
                            forecast_1_widget_temperatures,
                            detailedWeatherForecast.getFirstWeatherCondition().getIcon(),
                            detailedWeatherForecast.getDateTime(),
                            detailedWeatherForecast.getTemperatureMax(),
                            detailedWeatherForecast.getTemperatureMin(),
                            detailedWeatherForecast.getWindSpeed(),
                            location);
                    break;
                case 2:
                    setForecastHourInfo(
                            context,
                            fontColorId,
                            hourCounter,
                            hoursCount,
                            remoteViews,
                            forecast_2_widget_day_layout,
                            forecast_2_widget_icon,
                            detailedWeatherForecast.getFirstWeatherCondition().getWeatherId(),
                            forecast_2_widget_day,
                            forecast_2_widget_temperatures,
                            detailedWeatherForecast.getFirstWeatherCondition().getIcon(),
                            detailedWeatherForecast.getDateTime(),
                            detailedWeatherForecast.getTemperatureMax(),
                            detailedWeatherForecast.getTemperatureMin(),
                            detailedWeatherForecast.getWindSpeed(),
                            location);
                    break;
                case 3:
                    setForecastHourInfo(
                            context,
                            fontColorId,
                            hourCounter,
                            hoursCount,
                            remoteViews,
                            forecast_3_widget_day_layout,
                            forecast_3_widget_icon,
                            detailedWeatherForecast.getFirstWeatherCondition().getWeatherId(),
                            forecast_3_widget_day,
                            forecast_3_widget_temperatures,
                            detailedWeatherForecast.getFirstWeatherCondition().getIcon(),
                            detailedWeatherForecast.getDateTime(),
                            detailedWeatherForecast.getTemperatureMax(),
                            detailedWeatherForecast.getTemperatureMin(),
                            detailedWeatherForecast.getWindSpeed(),
                            location);
                    break;
                case 4:
                    setForecastHourInfo(
                            context,
                            fontColorId,
                            hourCounter,
                            hoursCount,
                            remoteViews,
                            forecast_4_widget_day_layout,
                            forecast_4_widget_icon,
                            detailedWeatherForecast.getFirstWeatherCondition().getWeatherId(),
                            forecast_4_widget_day,
                            forecast_4_widget_temperatures,
                            detailedWeatherForecast.getFirstWeatherCondition().getIcon(),
                            detailedWeatherForecast.getDateTime(),
                            detailedWeatherForecast.getTemperatureMax(),
                            detailedWeatherForecast.getTemperatureMin(),
                            detailedWeatherForecast.getWindSpeed(),
                            location);
                    break;
                case 5:
                    setForecastHourInfo(
                            context,
                            fontColorId,
                            hourCounter,
                            hoursCount,
                            remoteViews,
                            forecast_5_widget_day_layout,
                            forecast_5_widget_icon,
                            detailedWeatherForecast.getFirstWeatherCondition().getWeatherId(),
                            forecast_5_widget_day,
                            forecast_5_widget_temperatures,
                            detailedWeatherForecast.getFirstWeatherCondition().getIcon(),
                            detailedWeatherForecast.getDateTime(),
                            detailedWeatherForecast.getTemperatureMax(),
                            detailedWeatherForecast.getTemperatureMin(),
                            detailedWeatherForecast.getWindSpeed(),
                            location);
                    break;
            }
        }
        return weatherForecastRecord;
    }

