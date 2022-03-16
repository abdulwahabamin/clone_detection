    public CurrentWeatherData(int id, int city_id, long timestamp, int weatherID, float temperatureCurrent, float temperatureMin, float temperatureMax, float humidity, float pressure, float windSpeed, float windDirection, float cloudiness, long timeSunrise, long timeSunset) {
        this.id = id;
        this.city_id = city_id;
        this.timestamp = timestamp;
        this.weatherID = weatherID;
        this.temperatureCurrent = temperatureCurrent;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudiness = cloudiness;
        this.timeSunrise = timeSunrise;
        this.timeSunset = timeSunset;
    }

