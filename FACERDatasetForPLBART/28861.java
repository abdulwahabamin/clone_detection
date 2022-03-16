    /**
     * Different APIs will use different representation for weather conditions / categories.
     * Internally, they will stored uniformly. Implementation of this weather provide this
     * functionality.Category(jsonWeather.getString("main"));
     * forecast.setWeather
     *
     * @param category The category to convert into the internal representation.
     * @return Returns 10 for clear sky, 20 for (few) clouds, 30 for scattered cloud, 40 for broken
     * clouds, 50 for shower rain, 60 for rain, 70 for thunderstorm, 80 for snow, 90 for mist.
     */
    public abstract int convertWeatherCategory(String category);

