    private void updateResultInUI(Context context, String result, WeatherRequestDataHolder updateRequest) {
        if (updateRequest == null) {
            return;
        }
        WidgetUtils.updateWidgets(context);
        sendMessageToReconciliationDbService(false);
        String updateSource = updateRequest.getUpdateSource();
        if (updateSource == null) {
            return;
        }
        switch (updateSource) {
            case "FORECAST":
                sendIntentToForecast(result);
                break;
            case "GRAPHS":
                sendIntentToGraphs(result);
                break;
            case "MAIN":
                sendIntentToMain(result);
                break;
        }
    }

