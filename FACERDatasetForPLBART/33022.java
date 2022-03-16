    private void unbindCurrentWeatherService(Context context) {
        if (currentWeatherService == null) {
            return;
        }
        context.getApplicationContext().unbindService(currentWeatherServiceConnection);
    }

