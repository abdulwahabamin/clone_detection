    @Override
    public void displayRetrievedData(String jsonString, WeatherInfoType weatherInfoType) {
        if (isDualPane) {
            displayRetrievedDataInThisActivity(jsonString, weatherInfoType);
        } else {
            displayRetrievedDataInNewActivity(jsonString, weatherInfoType);
        }
    }

