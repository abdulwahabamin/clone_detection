    private void updateLocationCityTimeAndSource() {
        if (currentLocation == null) {
            return;
        }
        currentLocation = locationsDbHelper.getLocationById(currentLocation.getId());
        String lastUpdate = Utils.getLastUpdateTime(
                this,
                currentWeatherDbHelper.getWeather(currentLocation.getId()),
                weatherForecastDbHelper.getWeatherForecast(currentLocation.getId()),
                currentLocation);
        mLastUpdateView.setText(getString(R.string.last_update_label, lastUpdate));
        localityView.setText(Utils.getCityAndCountry(this, currentLocation.getOrderId()));
    }

