    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        if(selectedCity != null && database != null && !database.isCityWatched(selectedCity.getCityId())) {
            addCity();
        }
        startActivity(new Intent(TutorialActivity.this, ForecastCityActivity.class));
        getWeatherData();
        finish();
    }

