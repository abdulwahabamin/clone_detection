    @Override
    public void onRecentJsonStringRetrieved(String jsonString, WeatherInfoType weatherInfoType,
                                            boolean shouldSaveLocally) {
        if (shouldSaveLocally) {
            saveRetrievedData(jsonString, weatherInfoType);
        }
        displayRetrievedData(jsonString, weatherInfoType);
    }

