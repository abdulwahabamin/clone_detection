    public WeatherByVoiceRequestDataHolder(Location location, Weather weather, long timeNow) {
        this.location = location;
        this.weather = weather;
        this.timeNow = timeNow;
        this.timestamp = System.currentTimeMillis();
    }

