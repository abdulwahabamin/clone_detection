        @Override
        public void onClick(View view) {
            String temperatureScale = Utils.getTemperatureScale(MainActivity.this);
            mSpeedScale = Utils.getSpeedScale(MainActivity.this);
            String weather;
            String temperature;
            String description;
            String wind;
            String sunrise;
            String sunset;
            temperature = String.format(Locale.getDefault(), "%.0f", mPrefWeather.getFloat(Constants.WEATHER_DATA_TEMPERATURE, 0));
            description = mPrefWeather.getString(Constants.WEATHER_DATA_DESCRIPTION,
                    "clear sky");
            wind = String.format(Locale.getDefault(), "%.1f",
                    mPrefWeather.getFloat(Constants.WEATHER_DATA_WIND_SPEED, 0));
            sunrise = Utils.unixTimeToFormatTime(MainActivity.this, mPrefWeather
                    .getLong(Constants.WEATHER_DATA_SUNRISE, -1));
            sunset = Utils.unixTimeToFormatTime(MainActivity.this, mPrefWeather
                    .getLong(Constants.WEATHER_DATA_SUNSET, -1));
            weather = "City: " + Utils.getCityAndCountry(storedContext) +
                    "\nTemperature: " + temperature + temperatureScale +
                    "\nDescription: " + description +
                    "\nWind: " + wind + " " + mSpeedScale +
                    "\nSunrise: " + sunrise +
                    "\nSunset: " + sunset;
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, weather);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(Intent.createChooser(shareIntent, "Share Weather"));
            } catch (ActivityNotFoundException e) {
                Toast.makeText(MainActivity.this,
                        "Communication app not found",
                        Toast.LENGTH_LONG).show();
            }
        }

