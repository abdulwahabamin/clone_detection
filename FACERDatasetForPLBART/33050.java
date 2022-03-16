    @Override
    protected void sendWeatherUpdate(Context context, int widgetId) {
        super.sendWeatherUpdate(context, widgetId);
        if (currentLocation == null) {
            appendLog(context,
                    TAG,
                    "currentLocation is null");
            return;
        }
        if (currentLocation.getOrderId() != 0) {
            Intent intentToCheckWeather = new Intent(context, ForecastWeatherService.class);
            intentToCheckWeather.putExtra("locationId", currentLocation.getId());
            intentToCheckWeather.putExtra("forceUpdate", true);
            startServiceWithCheck(context, intentToCheckWeather);
        }
    }

