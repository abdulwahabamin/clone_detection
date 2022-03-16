        @Override
        public void onClick(View view) {
            CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(MainActivity.this);
            CurrentWeatherDbHelper.WeatherRecord currentWeatherRecord = currentWeatherDbHelper.getWeather(currentLocation.getId());

            if (currentWeatherRecord == null) {
                Toast.makeText(MainActivity.this,
                        getString(R.string.current_weather_has_not_been_fetched),
                        Toast.LENGTH_LONG).show();
                return;
            }

            Weather weather = currentWeatherRecord.getWeather();

            String temperatureWithUnit = TemperatureUtil.getTemperatureWithUnit(
                    MainActivity.this,
                    weather,
                    currentLocation.getLatitude(),
                    currentWeatherRecord.getLastUpdatedTime(),
                    currentLocation.getLocale());
            windWithUnit = AppPreference.getWindWithUnit(
                    MainActivity.this,
                    weather.getWindSpeed(),
                    weather.getWindDirection(),
                    currentLocation.getLocale());
            String description;
            String sunrise;
            String sunset;
            description = Utils.getWeatherDescription(MainActivity.this, currentLocation.getLocaleAbbrev(), weather);
            sunrise = Utils.unixTimeToFormatTime(MainActivity.this, weather.getSunrise(), currentLocation.getLocale());
            sunset = Utils.unixTimeToFormatTime(MainActivity.this, weather.getSunset(), currentLocation.getLocale());
            String weatherDescription = getString(R.string.share_weather_descritpion,
                                                  Utils.getLocationForSharingFromAddress(currentLocation.getAddress()),
                                                  temperatureWithUnit,
                                                  description,
                                                  windWithUnit.getWindSpeed(1),
                                                  windWithUnit.getWindUnit(),
                                                  sunrise,
                                                  sunset);
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, weatherDescription);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_weather_title)));
            } catch (ActivityNotFoundException e) {
                Toast.makeText(MainActivity.this,
                        getString(R.string.share_weather_app_not_found),
                        Toast.LENGTH_LONG).show();
            }
        }

