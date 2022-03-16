    public WeatherRequestDataHolder(long locationId, String updateSource) {
        this.locationId = locationId;
        this.updateSource = updateSource;
        this.attempts = 0;
        this.timestamp = System.currentTimeMillis();
        this.forceUpdate = false;
        this.updateWeatherOnly = false;
    }

