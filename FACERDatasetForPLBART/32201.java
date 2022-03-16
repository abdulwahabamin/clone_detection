    private void bindCurrentWeatherService() {
        appendLog(getBaseContext(), getClass().getSimpleName(), "bind current weather service:", this.toString());
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), CurrentWeatherService.class),
                currentWeatherServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

