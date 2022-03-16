    @Override
    public void onLocation(boolean success, String cityId) {
        if (!success) {
            Toast.makeText(WeatherApplication.getContext(), R.string.weather_add_city_hand_mode, Toast.LENGTH_LONG).show();
            SearchActivity.navigationFromApplication(WeatherApplication.getContext());
        } else {
            if(!CoreManager.getImpl(ICityProvider.class).hadCurrentCityId()) {
                CoreManager.getImpl(ICityProvider.class).saveCurrentCityId(cityId);
                updateWeather();
            }
        }

    }

