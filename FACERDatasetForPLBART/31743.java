    private void bindWeatherForecastService() {
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), ForecastWeatherService.class),
                weatherForecastServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

