    /**
     * @param category The category to get a textual representation for.
     * @return Returns the textual description of the given category. Fallback value is 'clouds'.
     */
    public String getWeatherDescriptionByCategory(IApiToDatabaseConversion.WeatherCategories category) {
        switch (category) {
            case CLEAR_SKY:
                return context.getResources().getString(R.string.weather_category_clear_sky);
            case CLOUDS:
                return context.getResources().getString(R.string.weather_category_clouds);
            case SCATTERED_CLOUDS:
                return context.getResources().getString(R.string.weather_category_scattered_clouds);
            case BROKEN_CLOUDS:
                return context.getResources().getString(R.string.weather_category_broken_clouds);
            case SHOWER_RAIN:
                return context.getResources().getString(R.string.weather_category_shower_rain);
            case RAIN:
                return context.getResources().getString(R.string.weather_category_rain);
            case THUNDERSTORM:
                return context.getResources().getString(R.string.weather_category_thunderstorm);
            case SNOW:
                return context.getResources().getString(R.string.weather_category_snow);
            case MIST:
                return context.getResources().getString(R.string.weather_category_mist);
            default:
                return context.getResources().getString(R.string.weather_category_clouds);
        }
    }

