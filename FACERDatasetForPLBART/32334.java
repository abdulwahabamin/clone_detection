    private void sendResult(String result, Context context) {
        stopRefreshRotation("STOP", 1);
        sendMessageToWakeUpService(
                AppWakeUpManager.FALL_DOWN,
                AppWakeUpManager.SOURCE_WEATHER_FORECAST
        );
        gettingWeatherStarted = false;
        WeatherRequestDataHolder updateRequest = weatherForecastUpdateMessages.poll();
        try {
            updateResultInUI(context, result, updateRequest);
            if (!weatherForecastUpdateMessages.isEmpty()) {
                resendTheIntentInSeveralSeconds(5);
            }
            if (WidgetRefreshIconService.isRotationActive) {
                return;
            }
            sendMessageToReconciliationDbService(false);
            WidgetUtils.updateWidgets(getBaseContext());
        } catch (Throwable exception) {
            appendLog(context, TAG, "Exception occured when starting the service:", exception);
        }
        startWeatherForecastUpdate(0);
    }

