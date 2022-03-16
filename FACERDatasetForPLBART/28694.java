    private void getWeatherData() {
        // Start a background task to retrieve and store the weather data
        if (selectedCity !=  null) {
            Intent updateService = new Intent(this, UpdateDataService.class);
            updateService.setAction(UpdateDataService.UPDATE_ALL_ACTION);
            updateService.putExtra(UpdateDataService.CITY_ID, selectedCity.getCityId());
            startService(updateService);
        }
    }

