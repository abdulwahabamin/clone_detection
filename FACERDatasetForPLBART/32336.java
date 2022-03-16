    private void saveWeatherAndSendResult(Context context, CompleteWeatherForecast completeWeatherForecast) {
        WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(context);
        long lastUpdate = System.currentTimeMillis();
        WeatherRequestDataHolder updateRequest = weatherForecastUpdateMessages.peek();
        if (updateRequest == null) {
            return;
        }
        weatherForecastDbHelper.saveWeatherForecast(updateRequest.getLocationId(),
                lastUpdate,
                completeWeatherForecast);
        GraphUtils.invalidateGraph();
        sendResult(ACTION_WEATHER_UPDATE_OK, context);
    }

