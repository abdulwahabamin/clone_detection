    private void sendResult(String result, Context context, Long locationId) {
        stopRefreshRotation("STOP", 2);
        sendMessageToWakeUpService(
                AppWakeUpManager.FALL_DOWN,
                AppWakeUpManager.SOURCE_CURRENT_WEATHER
        );
        gettingWeatherStarted = false;
        WeatherRequestDataHolder updateRequest = currentWeatherUpdateMessages.poll();
        appendLog(getBaseContext(),
                TAG,
                "currentWeatherUpdateMessages.size after pull when sending result = ", currentWeatherUpdateMessages);
        try {
            updateResultInUI(locationId, result, updateRequest);
            if (!currentWeatherUpdateMessages.isEmpty()) {
                resendTheIntentInSeveralSeconds(5);
            }
            WidgetUtils.updateWidgets(getBaseContext());
            if (WidgetRefreshIconService.isRotationActive) {
                return;
            }
            sendMessageToReconciliationDbService(false);
        } catch (Throwable exception) {
            appendLog(context, TAG, "Exception occured when starting the service:", exception);
        }
    }

