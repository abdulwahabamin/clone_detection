    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof WeatherByVoiceRequestDataHolder)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        WeatherByVoiceRequestDataHolder objToCompareTo = (WeatherByVoiceRequestDataHolder) obj;
        return (this.timeNow == objToCompareTo.timeNow) &&
               (((this.location == null) && (objToCompareTo.getLocation() == null)) ||
                ((this.weather != null) && (this.weather.equals(objToCompareTo.getWeather())))
        );
    }

