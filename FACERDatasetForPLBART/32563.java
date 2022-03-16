    public WeatherRequestDataHolder(long locationId, String updateSource, boolean forceUpdate, boolean updateWeatherOnly) {
        this.locationId = locationId;
        this.updateSource = updateSource;
        this.attempts = 0;
        this.timestamp = System.currentTimeMillis();
        this.forceUpdate = forceUpdate;
        this.updateWeatherOnly = updateWeatherOnly;
    }

