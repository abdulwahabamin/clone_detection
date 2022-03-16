    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof WeatherRequestDataHolder)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        WeatherRequestDataHolder objToCompareTo = (WeatherRequestDataHolder) obj;
        return (this.locationId == objToCompareTo.locationId) &&
               (((this.updateSource == null) && (objToCompareTo.getUpdateSource() == null)) ||
                ((this.updateSource != null) && (this.updateSource.equals(objToCompareTo.getUpdateSource())))) &&
               (this.forceUpdate == objToCompareTo.forceUpdate) &&
               (this.updateWeatherOnly == objToCompareTo.updateWeatherOnly);
    }

