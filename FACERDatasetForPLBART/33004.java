    protected void sendWeatherUpdate(Context context, int widgetId) {
        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        Long currentLocationId = widgetSettingsDbHelper.getParamLong(widgetId, "locationId");
        if (currentLocationId == null) {
            appendLog(context,
                    TAG,
                    "currentLocation is null");
            return;
        }
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        currentLocation = locationsDbHelper.getLocationById(currentLocationId);
        if (currentLocation == null) {
            appendLog(context,
                    TAG,
                    "currentLocation is null");
            return;
        }
        if ((currentLocation.getOrderId() == 0) && currentLocation.isEnabled()) {
            sendMessageToLocationUpdateService(context);
        } else if (currentLocation.getOrderId() != 0) {
            sendMessageToCurrentWeatherService(context, currentLocation, null, true, true);
        }
    }

