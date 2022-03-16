    private void bindCurrentWeatherService() {
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), CurrentWeatherService.class),
                currentWeatherServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

