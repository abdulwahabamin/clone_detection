    public static void setWeatherIcon(RemoteViews remoteViews,
                                               Context context,
                                               CurrentWeatherDbHelper.WeatherRecord weatherRecord,
                                               int widgetIconId) {
        if ("weather_icon_set_fontbased".equals(AppPreference.getIconSet(context))) {
            remoteViews.setImageViewBitmap(widgetIconId,
                    createWeatherIcon(context, getStrIcon(context, weatherRecord)));
        } else {
            remoteViews.setImageViewResource(widgetIconId, Utils.getWeatherResourceIcon(weatherRecord));
        }
    }

