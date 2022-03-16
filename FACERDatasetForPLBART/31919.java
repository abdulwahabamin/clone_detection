    public WeatherCondition getFirstWeatherCondition() {
        if (weatherConditions.isEmpty()) {
            return null;
        }
        return weatherConditions.get(0);
    }

