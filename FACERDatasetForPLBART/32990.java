    @Override
    protected void updateUI() {
        WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(this);
        long locationId = AppPreference.getCurrentLocationId(this);
        currentLocation = locationsDbHelper.getLocationById(locationId);
        if (currentLocation == null) {
            return;
        }
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(locationId);
        if (weatherForecastRecord != null) {
            weatherForecastList.put(locationId, weatherForecastRecord.getCompleteWeatherForecast().getWeatherForecastList());
            locationWeatherForecastLastUpdate.put(locationId, weatherForecastRecord.getLastUpdatedTime());
        } else if (ForecastUtil.shouldUpdateForecast(this, locationId)) {
            updateWeatherForecastFromNetwork("FORECAST", WeatherForecastActivity.this);
            return;
        }

        ImageView android = (ImageView) findViewById(R.id.android);
        if (weatherForecastList.isEmpty()) {
            mRecyclerView.setVisibility(View.INVISIBLE);
            android.setVisibility(View.VISIBLE);
        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
            android.setVisibility(View.GONE);
        }
        WeatherForecastAdapter adapter = new WeatherForecastAdapter(this,
                                                                    weatherForecastList.get(locationId),
                                                                    currentLocation.getLatitude(),
                                                                    currentLocation.getLocale(),
                                                                    visibleColumns);
        mRecyclerView.setAdapter(adapter);
        localityView.setText(Utils.getCityAndCountry(this, currentLocation.getOrderId()));
    }

