    @Override
    protected void updateUI() {
        long locationId = AppPreference.getCurrentLocationId(this);
        currentLocation = locationsDbHelper.getLocationById(locationId);
        if (currentLocation == null) {
            return;
        }

        CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(currentLocation.getId());
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(currentLocation.getId());

        if (weatherRecord == null) {
            mTemperatureView.setText(getString(R.string.temperature_with_degree,""));
            dewPointView.setText(getString(R.string.dew_point_label, ""));
            String temperatureTypeFromPreferences = PreferenceManager.getDefaultSharedPreferences(this).getString(
                    Constants.KEY_PREF_TEMPERATURE_TYPE, "measured_only");
            if ("measured_only".equals(temperatureTypeFromPreferences) ||
                    "appearance_only".equals(temperatureTypeFromPreferences)) {
                secondTemperatureView.setVisibility(View.GONE);
                iconSecondTemperatureView.setVisibility(View.GONE);
            } else {
                secondTemperatureView.setVisibility(View.VISIBLE);
                iconSecondTemperatureView.setVisibility(View.VISIBLE);
                secondTemperatureView.setText(getString(R.string.label_apparent_temperature,""));
            }
            mDescriptionView.setText(R.string.location_not_found);
            mLastUpdateView.setText(getString(R.string.last_update_label, ""));
            mHumidityView.setText(getString(R.string.humidity_label,
                    "",
                    ""));
            mPressureView.setText(getString(R.string.pressure_label,
                    "",
                    ""));
            mWindSpeedView.setText(getString(R.string.wind_label,"", "", ""));
            mCloudinessView.setText(getString(R.string.cloudiness_label,
                    "",
                    ""));
            mSunriseView.setText(getString(R.string.sunrise_label, ""));
            mSunsetView.setText(getString(R.string.sunset_label, ""));
            return;
        }

        Weather weather = weatherRecord.getWeather();

        String lastUpdate = Utils.getLastUpdateTime(this, weatherRecord, weatherForecastRecord, currentLocation);
        windWithUnit = AppPreference.getWindWithUnit(this,
                                                     weather.getWindSpeed(),
                                                     weather.getWindDirection(),
                                                     currentLocation.getLocale());
        PressureWithUnit pressure = AppPreference.getPressureWithUnit(this,
                                                                      weather.getPressure(),
                                                                      currentLocation.getLocale());
        String sunrise = Utils.unixTimeToFormatTime(this, weather.getSunrise(), currentLocation.getLocale());
        String sunset = Utils.unixTimeToFormatTime(this, weather.getSunset(), currentLocation.getLocale());

        Utils.setWeatherIcon(mIconWeatherView, this, weatherRecord);
        mTemperatureView.setText(getString(R.string.temperature_with_degree,
                TemperatureUtil.getTemperatureWithUnit(this,
                        weather,
                        currentLocation.getLatitude(),
                        weatherRecord.getLastUpdatedTime(),
                        currentLocation.getLocale())));
        dewPointView.setText(getString(R.string.dew_point_label, 
                             TemperatureUtil.getDewPointWithUnit(this, weather, currentLocation.getLocale())));
        String secondTemperature = TemperatureUtil.getSecondTemperatureWithLabel(this,
                weather,
                currentLocation.getLatitude(),
                weatherRecord.getLastUpdatedTime(),
                currentLocation.getLocale());
        if (secondTemperature != null) {
            secondTemperatureView.setText(secondTemperature);
            secondTemperatureView.setVisibility(View.VISIBLE);
            iconSecondTemperatureView.setVisibility(View.VISIBLE);
        } else {
            secondTemperatureView.setVisibility(View.GONE);
            iconSecondTemperatureView.setVisibility(View.GONE);
        }
        mDescriptionView.setText(Utils.getWeatherDescription(this, currentLocation.getLocaleAbbrev(), weather));
        mLastUpdateView.setText(getString(R.string.last_update_label, lastUpdate));
        mHumidityView.setText(getString(R.string.humidity_label,
                String.valueOf(weather.getHumidity()),
                mPercentSign));
        mPressureView.setText(getString(R.string.pressure_label,
                pressure.getPressure(AppPreference.getPressureDecimalPlaces(this)),
                pressure.getPressureUnit()));
        mWindSpeedView.setText(getString(R.string.wind_label,
                                         windWithUnit.getWindSpeed(1),
                                         windWithUnit.getWindUnit(),
                                         windWithUnit.getWindDirection()));
        mCloudinessView.setText(getString(R.string.cloudiness_label,
                String.valueOf(weather.getClouds()),
                mPercentSign));
        mSunriseView.setText(getString(R.string.sunrise_label, sunrise));
        mSunsetView.setText(getString(R.string.sunset_label, sunset));
        localityView.setText(Utils.getCityAndCountry(this, currentLocation.getOrderId()));
    }

