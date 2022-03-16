    private void bindWeatherByVoiceService() {
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), WeatherByVoiceService.class),
                weatherByVoiceServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

