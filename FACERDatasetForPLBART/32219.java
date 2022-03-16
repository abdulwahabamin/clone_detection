    protected void sendIntentToMain(String result) {
        Intent intent = new Intent(CurrentWeatherService.ACTION_WEATHER_UPDATE_RESULT);
        intent.setPackage("org.thosp.yourlocalweather");
        if (result.equals(CurrentWeatherService.ACTION_WEATHER_UPDATE_OK)) {
            intent.putExtra(
                    CurrentWeatherService.ACTION_WEATHER_UPDATE_RESULT,
                    CurrentWeatherService.ACTION_WEATHER_UPDATE_OK);
        } else if (result.equals(CurrentWeatherService.ACTION_WEATHER_UPDATE_FAIL)) {
            intent.putExtra(
                    CurrentWeatherService.ACTION_WEATHER_UPDATE_RESULT,
                    CurrentWeatherService.ACTION_WEATHER_UPDATE_FAIL);
        }
        sendBroadcast(intent);
    }

