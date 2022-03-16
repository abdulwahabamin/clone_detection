    private void updateResultInUI(Long locationId, String result, WeatherRequestDataHolder updateRequest) {
        if (updateRequest == null) {
            return;
        }
        String updateSource = updateRequest.getUpdateSource();
        if (updateSource != null) {
            switch (updateSource) {
                case "MAIN":
                    sendIntentToMain(result);
                    break;
            }
        }
        if (ACTION_WEATHER_UPDATE_OK.equals(result)) {
            weatherNotification(locationId, updateSource);
        }
    }

