    private static Notification regularNotification(Context context,
                                                    Location location,
                                                    int notificationIcon,
                                                    boolean isOutgoing,
                                                    CurrentWeatherDbHelper.WeatherRecord weatherRecord) {
        Weather weather = weatherRecord.getWeather();
        String temperatureWithUnit = TemperatureUtil.getTemperatureWithUnit(
                context,
                weather,
                location.getLatitude(),
                weatherRecord.getLastUpdatedTime(),
                location.getLocale());

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent launchIntent = PendingIntent.getActivity(context, 0, intent, 0);
        String cityAndCountry = Utils.getCityAndCountry(context, location.getOrderId());
        return new NotificationCompat.Builder(context, "yourLocalWeather")
                .setContentIntent(launchIntent)
                .setSmallIcon(notificationIcon)
                .setTicker(temperatureWithUnit
                        + "  "
                        + cityAndCountry)
                .setContentTitle(temperatureWithUnit +
                        "  " +
                        Utils.getWeatherDescription(context, location.getLocaleAbbrev(), weatherRecord.getWeather()))
                .setContentText(cityAndCountry)
                .setVibrate(isVibrateEnabled(context))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), Utils.getWeatherResourceIcon(weatherRecord)))
                .setOngoing(isOutgoing)
                .build();
    }

