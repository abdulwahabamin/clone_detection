    private void unbindCurrentWeatherService() {
        if (currentWeatherService == null) {
            return;
        }
        try {
            getApplicationContext().unbindService(currentWeatherServiceConnection);
        } catch (Exception e) {
            appendLog(this, "TAG", e.getMessage(), e);
        }
    }

