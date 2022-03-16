    /**
     * @see IDataExtractor#extractForecast(String)
     */
    @Override
    public Forecast extractForecast(String data) {
        try {
            /*
            code Internal parameter
            message Internal parameter
            city
                city.id City ID
                city.name City name
                city.coord
                    city.coord.lat City geo location, latitude
                    city.coord.lon City geo location, longitude
                city.country Country code (GB, JP etc.)
            cnt Number of lines returned by this API call
            list
                list.dt Time of data forecasted, unix, UTC
                list.main
                    list.main.temp Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
                    list.main.temp_min Minimum temperature at the moment of calculation. This is deviation from 'temp' that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
                    list.main.temp_max Maximum temperature at the moment of calculation. This is deviation from 'temp' that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
                    list.main.pressure Atmospheric pressure on the sea level by default, hPa
                    list.main.sea_level Atmospheric pressure on the sea level, hPa
                    list.main.grnd_level Atmospheric pressure on the ground level, hPa
                    list.main.humidity Humidity, %
                    list.main.temp_kf Internal parameter
                list.weather (more info Weather condition codes)
                    list.weather.id Weather condition id
                    list.weather.main Group of weather parameters (Rain, Snow, Extreme etc.)
                    list.weather.description Weather condition within the group
                    list.weather.icon Weather icon id
                list.clouds
                    list.clouds.all Cloudiness, %
                list.wind
                    list.wind.speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
                    list.wind.deg Wind direction, degrees (meteorological)
                list.rain
                    list.rain.3h Rain volume for last 3 hours, mm
                list.snow
                    list.snow.3h Snow volume for last 3 hours
                list.dt_txt Data/time of caluclation, UTC
             */
            Forecast forecast = new Forecast();
            JSONObject jsonData = new JSONObject(data);

            forecast.setTimestamp(System.currentTimeMillis() / 1000);
            //forecast.setTimestamp(jsonData.getLong("dt"));

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date forecastTime = formatter.parse(jsonData.getString("dt_txt"));
            forecast.setForecastTime(forecastTime);

            IApiToDatabaseConversion conversion = new OwmToDatabaseConversion();
            JSONArray jsonWeatherArray = jsonData.getJSONArray("weather");
            JSONObject jsonWeather = new JSONObject(jsonWeatherArray.get(0).toString());
            forecast.setWeatherID(conversion.convertWeatherCategory(jsonWeather.getString("id")));

            JSONObject jsonMain = jsonData.getJSONObject("main");
            forecast.setTemperature((float) jsonMain.getDouble("temp"));
            forecast.setHumidity((float) jsonMain.getDouble("humidity"));
            forecast.setPressure((float) jsonMain.getDouble("pressure"));

            //TODO: Save wind for the 3h forecast?
            //JSONObject jsonWind = jsonData.getJSONObject("wind");
            //forecast.setWindSpeed((float) jsonWind.getDouble("speed"));
            //forecast.setWindDirection((float) jsonWind.getDouble("deg"));

            //TODO: leave this out?
            // In case there was no rain in the past 3 hours, there is no "rain" field
            /*if (jsonData.isNull("rain")) {
                forecast.setPastRainVolume(Forecast.NO_RAIN_VALUE);
            } else {
                JSONObject jsonRain = jsonData.getJSONObject("rain");
                if (jsonRain.isNull("3h")) {
                    forecast.setPastRainVolume(Forecast.NO_RAIN_VALUE);
                } else {
                    forecast.setPastRainVolume((float) jsonRain.getDouble("3h"));
                }
            }*/

            return forecast;
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

