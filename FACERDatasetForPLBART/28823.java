    /**
     * @param categoryNumber The category number. See IApiToDatabaseConversion#WeatherCategories
     *                       for details.
     * @return Returns the icon (resource) that belongs to the given category number.
     */
    public static int getIconResourceForWeatherCategory(int categoryNumber) {
        switch (categoryNumber) {
            case 10:
                return R.mipmap.weather_icon_sunny;
            case 20:
                return R.mipmap.weather_icon_sunny_with_clouds;
            case 30:
                return R.mipmap.weather_icon_cloudy_scattered;
            case 40:
                return R.mipmap.weather_icon_clouds_broken;
            case 50:
                return R.mipmap.weather_icon_foggy;
            case 60:
                return R.mipmap.weather_icon_rain;
            case 70:
                return R.mipmap.weather_icon_rain;
            case 80:
                return R.mipmap.weather_icon_snow;
            case 90:
                return R.mipmap.weather_icon_thunderstorm;
            default:
                return R.mipmap.weather_icon_cloudy_scattered;
        }
    }

