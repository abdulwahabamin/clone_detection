    protected void unbindServices() {
        appendLog(getBaseContext(), TAG, "unbindServices start");
        try {
            if (widgetRefreshIconService != null) {
                getApplicationContext().unbindService(widgetRefreshIconConnection);
            }
            if (locationUpdateService != null) {
                getApplicationContext().unbindService(locationUpdateServiceConnection);
            }
            unbindCurrentWeatherService();
            unbindWeatherForecastService();
            unbindwakeUpService();
            unbindReconciliationDbService();
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, e);
        }
        appendLog(getBaseContext(), TAG, "unbindServices end");
    }

