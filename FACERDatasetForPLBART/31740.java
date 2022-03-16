    protected void sendMessageToWeatherForecastService(Long locationId) {
        if (!ForecastUtil.shouldUpdateForecast(this, locationId)) {
            return;
        }
        sendMessageToWeatherForecastService(locationId, null);
    }

