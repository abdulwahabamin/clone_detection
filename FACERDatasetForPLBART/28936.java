    private static void updateView(Context context, AppWidgetManager appWidgetManager, RemoteViews views, int appWidgetId, List<Forecast> forecastList, City city) {
        AppPreferencesManager prefManager =
                new AppPreferencesManager(PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");

        //forecastList = DayForecastFilter.filter(forecastList, 5);
        if(forecastList.size() < 5) return;

        String day1 = dayFormat.format(forecastList.get(0).getForecastTime());
        String day2 = dayFormat.format(forecastList.get(1).getForecastTime());
        String day3 = dayFormat.format(forecastList.get(2).getForecastTime());
        String day4 = dayFormat.format(forecastList.get(3).getForecastTime());
        String day5 = dayFormat.format(forecastList.get(4).getForecastTime());

        String temperature1 = String.format(
                "%s%s",
                decimalFormat.format(prefManager.convertTemperatureFromCelsius(forecastList.get(0).getTemperature())),
                prefManager.getWeatherUnit()
        );
        String temperature2 = String.format(
                "%s%s",
                decimalFormat.format(prefManager.convertTemperatureFromCelsius(forecastList.get(1).getTemperature())),
                prefManager.getWeatherUnit()
        );
        String temperature3 = String.format(
                "%s%s",
                decimalFormat.format(prefManager.convertTemperatureFromCelsius(forecastList.get(2).getTemperature())),
                prefManager.getWeatherUnit()
        );
        String temperature4 = String.format(
                "%s%s",
                decimalFormat.format(prefManager.convertTemperatureFromCelsius(forecastList.get(3).getTemperature())),
                prefManager.getWeatherUnit()
        );
        String temperature5 = String.format(
                "%s%s",
                decimalFormat.format(prefManager.convertTemperatureFromCelsius(forecastList.get(4).getTemperature())),
                prefManager.getWeatherUnit()
        );

        String hum1 = String.format("%s %%", forecastList.get(0).getHumidity());
        String hum2 = String.format("%s %%", forecastList.get(1).getHumidity());
        String hum3 = String.format("%s %%", forecastList.get(2).getHumidity());
        String hum4 = String.format("%s %%", forecastList.get(3).getHumidity());
        String hum5 = String.format("%s %%", forecastList.get(4).getHumidity());

        views.setTextViewText(R.id.widget_city_name, city.getCityName());

        views.setTextViewText(R.id.widget_city_weather_5day_day1, day1);
        views.setTextViewText(R.id.widget_city_weather_5day_day2, day2);
        views.setTextViewText(R.id.widget_city_weather_5day_day3, day3);
        views.setTextViewText(R.id.widget_city_weather_5day_day4, day4);
        views.setTextViewText(R.id.widget_city_weather_5day_day5, day5);
        views.setTextViewText(R.id.widget_city_weather_5day_temp1, temperature1);
        views.setTextViewText(R.id.widget_city_weather_5day_temp2, temperature2);
        views.setTextViewText(R.id.widget_city_weather_5day_temp3, temperature3);
        views.setTextViewText(R.id.widget_city_weather_5day_temp4, temperature4);
        views.setTextViewText(R.id.widget_city_weather_5day_temp5, temperature5);
        views.setTextViewText(R.id.widget_city_weather_5day_hum1, hum1);
        views.setTextViewText(R.id.widget_city_weather_5day_hum2, hum2);
        views.setTextViewText(R.id.widget_city_weather_5day_hum3, hum3);
        views.setTextViewText(R.id.widget_city_weather_5day_hum4, hum4);
        views.setTextViewText(R.id.widget_city_weather_5day_hum5, hum5);

        views.setImageViewResource(R.id.widget_city_weather_5day_image1, UiResourceProvider.getIconResourceForWeatherCategory(forecastList.get(0).getWeatherID()));
        views.setImageViewResource(R.id.widget_city_weather_5day_image2, UiResourceProvider.getIconResourceForWeatherCategory(forecastList.get(1).getWeatherID()));
        views.setImageViewResource(R.id.widget_city_weather_5day_image3, UiResourceProvider.getIconResourceForWeatherCategory(forecastList.get(2).getWeatherID()));
        views.setImageViewResource(R.id.widget_city_weather_5day_image4, UiResourceProvider.getIconResourceForWeatherCategory(forecastList.get(3).getWeatherID()));
        views.setImageViewResource(R.id.widget_city_weather_5day_image5, UiResourceProvider.getIconResourceForWeatherCategory(forecastList.get(4).getWeatherID()));

        Intent intent = new Intent(context, ForecastCityActivity.class);
        intent.putExtra("cityId", forecastList.get(0).getCity_id());
        PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId, intent, 0);
        views.setOnClickPendingIntent(R.id.widget_city_weather_image_view, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

