    private void unbindWeatherForecastService() {
        if (weatherForecastService == null) {
            return;
        }
        getApplicationContext().unbindService(weatherForecastServiceConnection);
    }

