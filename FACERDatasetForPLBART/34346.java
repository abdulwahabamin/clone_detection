    public void parseWeather(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            JSONObject weatherObject = weatherArray.getJSONObject(0);
            if (weatherObject.has("description")) {
                mWeather.currentWeather.setDescription(weatherObject.getString("description"));
            }
            if (weatherObject.has("icon")) {
                mWeather.currentWeather.setIdIcon(weatherObject.getString("icon"));
            }

            JSONObject mainObj = jsonObject.getJSONObject("main");
            if (mainObj.has("temp")) {
                mWeather.temperature.setTemp(Float.parseFloat(mainObj.getString("temp")));
            }
            if (mainObj.has("pressure")) {
                mWeather.currentCondition.setPressure(
                        Float.parseFloat(mainObj.getString("pressure")));
            }
            if (mainObj.has("humidity")) {
                mWeather.currentCondition.setHumidity(mainObj.getInt("humidity"));
            }

            JSONObject windObj = jsonObject.getJSONObject("wind");
            if (windObj.has("speed")) {
                mWeather.wind.setSpeed(Float.parseFloat(windObj.getString("speed")));
            }
            if (windObj.has("deg")) {
                mWeather.wind.setDirection(Float.parseFloat(windObj.getString("deg")));
            }

            JSONObject cloudsObj = jsonObject.getJSONObject("clouds");
            if (cloudsObj.has("all")) {
                mWeather.cloud.setClouds(cloudsObj.getInt("all"));
            }

            if (jsonObject.has("name")) {
                mCitySearch.setCityName(jsonObject.getString("name"));
            }

            JSONObject sysObj = jsonObject.getJSONObject("sys");
            if (sysObj.has("country")) {
                mCitySearch.setCountryCode(sysObj.getString("country"));
            }
            mWeather.sys.setSunrise(sysObj.getLong("sunrise"));
            mWeather.sys.setSunset(sysObj.getLong("sunset"));

            mWeather.location = mCitySearch;
            sendResult(ACTION_WEATHER_UPDATE_OK);
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing JSON");
            sendResult(ACTION_WEATHER_UPDATE_FAIL);
        }
    }

