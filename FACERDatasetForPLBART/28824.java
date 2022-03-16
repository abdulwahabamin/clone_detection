    /**
     * @param categoryNumber The category number. See IApiToDatabaseConversion#WeatherCategories
     *                       for details.
     * @return Returns the image resource that belongs to the given category number.
     */
    public static int getImageResourceForWeatherCategory(int categoryNumber) {
        switch (categoryNumber) {
            case 10:
                return R.drawable.weather_image_sunny;
            case 20:
                return R.drawable.weather_image_sunny_with_clouds;
            case 30:
                return R.drawable.weather_image_scattered_clouds;
            case 40:
                return R.drawable.weather_image_broken_clouds;
            case 50:
                return R.drawable.weather_image_foggy;
            case 60:
                return R.drawable.weather_image_rain;
            case 70:
                return R.drawable.weather_image_rain;
            case 80:
                return R.drawable.weather_image_snow;
            case 90:
                return R.drawable.weather_image_thunderstorm;
            default:
                return R.drawable.weather_image_scattered_clouds;
        }
    }

