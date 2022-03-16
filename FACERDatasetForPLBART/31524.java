    @Override
    public void showNotificationWeather(boolean shouldNotify) {
        ivShouldNotify.setImageResource(shouldNotify ? R.drawable.preference_checkbox_on : R.drawable.preference_checkbox_off);
        if (!shouldNotify) {
            stopService(new Intent(getApplicationContext(), WeatherNotificationService.class));
        } else {
            startService(new Intent(getApplicationContext(), WeatherNotificationService.class));
        }
    }

