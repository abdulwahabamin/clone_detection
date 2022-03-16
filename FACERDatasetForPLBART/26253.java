    public void update(WeatherData weatherData) {
        if (weatherData != null) {
            this.cityId = weatherData.getCityId();
            this.cityName = weatherData.getBasic().getCity();
            this.temp = weatherData.getBasic().getTemp();
            this.weatherStatus = weatherData.getBasic().getWeather();
        }
    }

