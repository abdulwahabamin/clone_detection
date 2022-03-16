    private static void updateView(Context context, AppWidgetManager appWidgetManager, RemoteViews views, int appWidgetId, City city, CurrentWeatherData weatherData) {
        AppPreferencesManager prefManager =
                new AppPreferencesManager(PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String temperature = String.format(
                "%s%s",
                decimalFormat.format(prefManager.convertTemperatureFromCelsius(weatherData.getTemperatureCurrent())),
                prefManager.getWeatherUnit()
        );
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(weatherData.getTimeSunrise() * 1000);
        String sunRise = timeFormat.format(cal.getTime());
        cal.setTimeInMillis(weatherData.getTimeSunset() * 1000);
        String sunSet = timeFormat.format(cal.getTime());

        String windSpeed = String.format("%s m/s", weatherData.getWindSpeed());

        views.setTextViewText(R.id.widget_city_weather_temperature, temperature);
        views.setTextViewText(R.id.widget_city_weather_humidity, String.format("%s %%", weatherData.getHumidity()));
        views.setTextViewText(R.id.widget_city_name, city.getCityName());
        views.setTextViewText(R.id.widget_city_weather_rise, sunRise);
        views.setTextViewText(R.id.widget_city_weather_set, sunSet);
        views.setTextViewText(R.id.widget_city_weather_wind, windSpeed);

        views.setImageViewResource(R.id.widget_city_weather_image_view, UiResourceProvider.getIconResourceForWeatherCategory(weatherData.getWeatherID()));

        Intent intent = new Intent(context, ForecastCityActivity.class);
        intent.putExtra("cityId", city.getCityId());
        PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId, intent, 0);
        views.setOnClickPendingIntent(R.id.widget_city_weather_image_view, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

