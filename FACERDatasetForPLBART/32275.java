    private void scheduleNextLocationWeatherForecastUpdate(long locationId) {
        if (!ForecastUtil.shouldUpdateForecast(this, locationId)) {
            return;
        }
        sendMessageToWeatherForecastService(locationId);
    }

