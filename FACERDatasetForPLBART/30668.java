    @Override
    public void showCityWeatherData(CityWeather cityWeather) {

        cityWeatherIconImageView
                .setImageResource(WeatherUtils
                        .getArtResourceForWeatherCondition(cityWeather.getWeather().get(0).getId()));
    }

