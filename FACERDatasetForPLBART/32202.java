    private void unbindCurrentWeatherService() {
        if (currentWeatherService == null) {
            return;
        }
        getApplicationContext().unbindService(currentWeatherServiceConnection);
    }

