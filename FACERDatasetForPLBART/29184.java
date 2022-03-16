    public static Weather getWeather(String data) throws JSONException {

        JSONObject mainObj = new JSONObject(data);
        JSONObject coordinatesObj = getObject(COORDINATES, mainObj);
        JSONObject extrasObj = getObject(EXTRAS, mainObj);
        JSONObject weatherObj = mainObj.getJSONArray(WEATHER).getJSONObject(0);
        JSONObject currentOjb = getObject(CURRENT, mainObj);
        JSONObject cloudsObj = getObject(CLOUDS, mainObj);
        JSONObject windObj = getObject(WIND, mainObj);

        Weather weather = new Weather();

        // Location data
        weather.getLocation().setCity(getString(CITY, mainObj));
        weather.getLocation().setLatitude(getFloat(LATITUDE, coordinatesObj));
        weather.getLocation().setLongitude(getFloat(LONGITUDE, coordinatesObj));
        weather.getLocation().setCountry(getString(EXTRAS_COUNTRY, extrasObj));

        // Current condition
        weather.getCurrentCondition().setDescription(getString(WEATHER_DESCRIPTION, weatherObj));
        weather.getCurrentCondition().setCondition(getString(WEATHER_TITLE, weatherObj));
        weather.getCurrentCondition().setIcon(getString(WEATHER_ICON_STRING, weatherObj));
        weather.getCurrentCondition().setHumidity(getInt(CURRENT_HUMIDITY, currentOjb));
        weather.getCurrentCondition().setPressure(getInt(CURRENT_PRESSURE, currentOjb));

        // Temperature data
        weather.getTemperature().setMaxTemperature(getFloat(CURRENT_MAX_TEMPERATURE, currentOjb));
        weather.getTemperature().setMinTemperature(getFloat(CURRENT_MIN_TEMPERATURE, currentOjb));
        weather.getTemperature().setTemperature(getFloat(CURRENT_TEMPERATURE, currentOjb));

        // Wind data
        weather.getWind().setSpeed(getFloat(WIND_SPEED, windObj));
        weather.getWind().setDegrees(getFloat(WIND_DEGREES, windObj));

        // Clouds data
        weather.getClouds().setPrecipitation(getInt(CLOUDINESS, cloudsObj));

        return weather;
    }

