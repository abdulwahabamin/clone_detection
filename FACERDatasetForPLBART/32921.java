    private static WeatherForecastDbHelper.WeatherForecastRecord createForecastByDays(
            Context context,
            int fontColorId,
            WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord,
            SimpleDateFormat sdfDayOfWeek,
            Long daysCount,
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
            int forecast_5_widget_temperatures
    ) {
        Set<ForecastUtil.WeatherForecastPerDay> countedForecast = ForecastUtil.calculateWeatherForDays(weatherForecastRecord);
        for (ForecastUtil.WeatherForecastPerDay countedForecastForDay: countedForecast) {
            switch (countedForecastForDay.dayIndex) {
                case 1:
                    setForecastDayInfo(
                            context,
                            countedForecastForDay,
                            fontColorId,
                            daysCount,
                            remoteViews,
                            forecast_1_widget_day_layout,
                            forecast_1_widget_icon,
                            forecast_1_widget_day,
                            forecast_1_widget_temperatures,
                            sdfDayOfWeek);
                    break;
                case 2:
                    setForecastDayInfo(
                            context,
                            countedForecastForDay,
                            fontColorId,
                            daysCount,
                            remoteViews,
                            forecast_2_widget_day_layout,
                            forecast_2_widget_icon,
                            forecast_2_widget_day,
                            forecast_2_widget_temperatures,
                            sdfDayOfWeek);
                    break;
                case 3:
                    setForecastDayInfo(
                            context,
                            countedForecastForDay,
                            fontColorId,
                            daysCount,
                            remoteViews,
                            forecast_3_widget_day_layout,
                            forecast_3_widget_icon,
                            forecast_3_widget_day,
                            forecast_3_widget_temperatures,
                            sdfDayOfWeek);
                    break;
                case 4:
                    setForecastDayInfo(
                            context,
                            countedForecastForDay,
                            fontColorId,
                            daysCount,
                            remoteViews,
                            forecast_4_widget_day_layout,
                            forecast_4_widget_icon,
                            forecast_4_widget_day,
                            forecast_4_widget_temperatures,
                            sdfDayOfWeek);
                    break;
                case 5:
                    setForecastDayInfo(
                            context,
                            countedForecastForDay,
                            fontColorId,
                            daysCount,
                            remoteViews,
                            forecast_5_widget_day_layout,
                            forecast_5_widget_icon,
                            forecast_5_widget_day,
                            forecast_5_widget_temperatures,
                            sdfDayOfWeek);
                    break;
            }
        }
        return weatherForecastRecord;
    }

