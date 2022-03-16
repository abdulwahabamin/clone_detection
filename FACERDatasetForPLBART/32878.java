    public static void setForecastIcon(RemoteViews remoteViews,
                                      Context context,
                                      int viewIconId,
                                       Integer weatherId,
                                       String iconId,
                                       double maxTemp,
                                       double maxWind,
                                       int fontColorId) {
        if ("weather_icon_set_fontbased".equals(AppPreference.getIconSet(context))) {
            remoteViews.setImageViewBitmap(viewIconId,
                    createWeatherIconWithColor(context, getStrIcon(context, iconId), fontColorId));
        } else {
            remoteViews.setImageViewResource(viewIconId, Utils.getWeatherResourceIcon(weatherId, maxTemp, maxWind));
        }
    }

