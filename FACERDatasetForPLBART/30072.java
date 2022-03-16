    public void saveWeather(WeatherInfo weather) {
        setTemperature(weather.getMain().getTemp());
        setPressure(weather.getMain().getPressure());
        setHumidity(weather.getMain().getHumidity());
        setSpeed(weather.getWind().getSpeed());
        setIcon(weather.getWeather().get(0).getId());
        setCountry(weather.getSys().getCountry());
        setDescription(weather.getWeather().get(0).getDescription());
    }

