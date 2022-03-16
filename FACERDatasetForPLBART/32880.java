    public static void setWeatherIconWithColor(RemoteViews remoteViews,
                                      Context context,
                                      CurrentWeatherDbHelper.WeatherRecord weatherRecord,
                                      int widgetIconId,
                                      int fontColorId) {
        if ("weather_icon_set_fontbased".equals(AppPreference.getIconSet(context))) {
            remoteViews.setImageViewBitmap(widgetIconId,
                    createWeatherIconWithColor(context, getStrIcon(context, weatherRecord), fontColorId));
        } else {
            remoteViews.setImageViewResource(widgetIconId, Utils.getWeatherResourceIcon(weatherRecord));
        }
    }

