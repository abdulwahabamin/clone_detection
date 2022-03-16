    public Forecast(int id, int city_id, long timestamp, Date forecastFor, int weatherID, float temperature, float humidity,
                    float pressure) {
        this.id = id;
        this.city_id = city_id;
        this.timestamp = timestamp;
        this.forecastFor = forecastFor;
        this.weatherID = weatherID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

