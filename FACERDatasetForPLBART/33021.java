    private void bindCurrentWeatherService(Context context) {
        context.getApplicationContext().bindService(
                new Intent(context.getApplicationContext(), CurrentWeatherService.class),
                currentWeatherServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

