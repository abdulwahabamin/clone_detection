    public void startFetchingService(int cityId) {
        // Start a background task to retrieve and store the weather data
        Intent intent = new Intent(this, UpdateDataService.class);
        intent.setAction(UpdateDataService.UPDATE_ALL_ACTION);
        intent.putExtra("cityId", cityId);
        startService(intent);
    }

