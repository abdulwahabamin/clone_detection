    /**
     * @param data The data that contains the information to instantiate a CurrentWeatherData
     *             object.
     *             If data for a single city were requested, the response string can be
     *             passed as an argument.
     *             If data for multiple cities were requested, make sure to pass only one item
     *             of the response list at a time!
     * @return Returns an instance of CurrentWeatherData of the information could be extracted
     * successfully or null in case there was some error while parsing the response (which is not
     * too good because that means that the response of OpenWeatherMap was not well-formed).
     */
    @Override
    public CurrentWeatherData extractCurrentWeatherData(String data) {
        try {
            JSONObject jsonData = new JSONObject(data);
            CurrentWeatherData weatherData = new CurrentWeatherData();

            /*
            private int id;
            -private int city_id;
            -private long timestamp;
            -private int weatherID;
            -private float temperatureCurrent;
            -private float temperatureMin;
            -private float temperatureMax;
            -private float humidity;
            -private float pressure;
            -private float windSpeed;
            -private float windDirection;
            -private float cloudiness;
            -private long timeSunrise;
            -private long timeSunset;
             */

            /*
            coord
                coord.lon City geo location, longitude
                coord.lat City geo location, latitude
            weather (more info Weather condition codes)
                weather.id Weather condition id
                weather.main Group of weather parameters (Rain, Snow, Extreme etc.)
                weather.description Weather condition within the group
                weather.icon Weather icon id
            base Internal parameter
            main
                main.temp Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
                main.pressure Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
                main.humidity Humidity, %
                main.temp_min Minimum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
                main.temp_max Maximum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
                main.sea_level Atmospheric pressure on the sea level, hPa
                main.grnd_level Atmospheric pressure on the ground level, hPa
            wind
                wind.speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
                wind.deg Wind direction, degrees (meteorological)
            clouds
                clouds.all Cloudiness, %
            rain
                rain.3h Rain volume for the last 3 hours
            snow
                snow.3h Snow volume for the last 3 hours
            dt Time of data calculation, unix, UTC
            sys
                sys.type Internal parameter
                sys.id Internal parameter
                sys.message Internal parameter
                sys.country Country code (GB, JP etc.)
                sys.sunrise Sunrise time, unix, UTC
                sys.sunset Sunset time, unix, UTC
            id City ID
            name City name
            cod Internal parameter
             */

            weatherData.setTimestamp(jsonData.getLong("dt"));

            weatherData.setCity_id(jsonData.getInt("id"));

            // Maybe save coordinates as well?
            //JSONObject jsonCoords = jsonData.getJSONObject("coord");
            //weatherData.setLongitude((float) jsonMain.getDouble("lon"));
            //weatherData.setLatitude((float) jsonMain.getDouble("lat"));
            // Maybe the city name?
            //weatherData.setCityName(jsonMain.getString("name"));

            IApiToDatabaseConversion conversion = new OwmToDatabaseConversion();
            JSONArray jsonWeatherArray = jsonData.getJSONArray("weather");
            JSONObject jsonWeather = new JSONObject(jsonWeatherArray.get(0).toString());
            weatherData.setWeatherID(conversion.convertWeatherCategory(jsonWeather.getString("id")));

            JSONObject jsonMain = jsonData.getJSONObject("main");
            weatherData.setTemperatureCurrent((float) jsonMain.getDouble("temp"));
            weatherData.setTemperatureMin((float) jsonMain.getDouble("temp_min"));
            weatherData.setTemperatureMax((float) jsonMain.getDouble("temp_max"));
            weatherData.setHumidity((float) jsonMain.getDouble("humidity"));
            weatherData.setPressure((float) jsonMain.getDouble("pressure"));

            JSONObject jsonWind = jsonData.getJSONObject("wind");
            weatherData.setWindSpeed((float) jsonWind.getDouble("speed"));
            if (jsonWind.has("deg")) {
                weatherData.setWindDirection((float) jsonWind.getDouble("deg"));
            }

            JSONObject jsonClouds = jsonData.getJSONObject("clouds");
            weatherData.setCloudiness((float) jsonClouds.getDouble("all"));

            if (jsonData.has("sys")) {
                JSONObject jsonSunRiseSet = jsonData.getJSONObject("sys");
                weatherData.setTimeSunrise(jsonSunRiseSet.getLong("sunrise"));
                weatherData.setTimeSunset(jsonSunRiseSet.getLong("sunset"));
            }

            return weatherData;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

