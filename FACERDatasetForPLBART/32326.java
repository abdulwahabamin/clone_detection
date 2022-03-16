    private void unbindWeatherByVoiceService() {
        if (weatherByVoiceService == null) {
            return;
        }
        getApplicationContext().unbindService(weatherByVoiceServiceConnection);
    }

