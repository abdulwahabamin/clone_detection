    private void bindWeatherByVoiceService(Context context) {
        context.getApplicationContext().bindService(
                new Intent(context.getApplicationContext(), WeatherByVoiceService.class),
                weatherByVoiceServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

