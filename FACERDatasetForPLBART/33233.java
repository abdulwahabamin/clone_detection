    static WeatherData buildWeatherData(String response) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }

        WeatherData weatherData = new WeatherData();

        Clouds cloudsData = null;
        try {
            cloudsData = JsonUtil.getCloudsObjectFromJson(response);
            weatherData.setClouds(cloudsData);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setClouds(cloudsData);
        }

        Coord coordData = null;
        try {
            coordData = JsonUtil.getCoordObjectFromJson(response);
            weatherData.setCoord(coordData);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setCoord(coordData);
        }

        Main mainData = null;
        try {
            mainData = JsonUtil.getMainObjectFromJson(response);
            weatherData.setMain(mainData);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setMain(mainData);
        }

        Sys sysData = null;
        try {
            sysData = JsonUtil.getSysObjectFromJson(response);
            weatherData.setSys(sysData);
        } catch (JSONException e) {
            weatherData.setSys(sysData);
            Log.e(LOG_TAG, e.getMessage());
        }


        Weather[] weatherObjectData = null;
        try {
            weatherObjectData = JsonUtil.getWeatherObjectFromJson(response);
            weatherData.setWeather(weatherObjectData);
        } catch (JSONException e) {
            weatherData.setWeather(weatherObjectData);
            Log.e(LOG_TAG, e.getMessage());
        }


        Wind windData = null;
        try {
            windData = JsonUtil.getWindObjectFromJson(response);
            weatherData.setWind(windData);
        } catch (JSONException e) {
            weatherData.setWind(windData);
            Log.e(LOG_TAG, e.getMessage());
        }


        try {
            weatherData.setBase(jsonObject.getString("base"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setBase(null);
        }
        try {
            weatherData.setVisibility(jsonObject.getString("visibility"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setVisibility(null);
        }
        try {
            weatherData.setDt(jsonObject.getString("dt"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setDt(null);

        }
        try {
            weatherData.setId(jsonObject.getString("id"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setId(null);
        }
        try {
            weatherData.setName(jsonObject.getString("name"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setName(null);
        }
        try {
            weatherData.setCod(jsonObject.getString("cod"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setCod(null);
        }

        return weatherData;
    }

