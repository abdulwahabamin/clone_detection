    protected void sendIntentToMain() {
        Intent intent = new Intent(CurrentWeatherService.ACTION_WEATHER_UPDATE_RESULT);
        intent.putExtra(
                CurrentWeatherService.ACTION_WEATHER_UPDATE_RESULT,
                CurrentWeatherService.ACTION_WEATHER_UPDATE_FAIL);
        WidgetUtils.startBackgroundService(getBaseContext(), intent);
    }

