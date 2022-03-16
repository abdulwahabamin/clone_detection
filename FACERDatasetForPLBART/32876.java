    public static void setWeatherIconWithColor(ImageView imageView,
                                      Context context,
                                      CurrentWeatherDbHelper.WeatherRecord weatherRecord,
                                      int fontColorId) {
        if ("weather_icon_set_fontbased".equals(AppPreference.getIconSet(context))) {
            imageView.setImageBitmap(createWeatherIconWithColor(context, getStrIcon(context, weatherRecord), fontColorId));
        } else {
            imageView.setImageResource(Utils.getWeatherResourceIcon(weatherRecord));
        }
    }

