    private void unbindWeatherByVoiceService(Context context) {
        if (weatherByVoiceService == null) {
            return;
        }
        context.getApplicationContext().unbindService(weatherByVoiceServiceConnection);
    }

