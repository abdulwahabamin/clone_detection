    public static CompleteWeatherForecast getWeatherForecast(Context context,
                                            long locationId,
                                            String weatherForecastResponseTxt) throws JSONException {
        CompleteWeatherForecast completeWeatherForecast = new CompleteWeatherForecast();
        JSONObject weatherForecastResponse = new JSONObject(weatherForecastResponseTxt);
        JSONArray weatherForecastList = weatherForecastResponse.getJSONArray("list");
        for (int weatherForecastCounter = 0; weatherForecastCounter < weatherForecastList.length(); weatherForecastCounter++) {
            DetailedWeatherForecast weatherForecast = new DetailedWeatherForecast();
            JSONObject weatherForecastCase = weatherForecastList.getJSONObject(weatherForecastCounter);
            weatherForecast.setDateTime(weatherForecastCase.getLong("dt"));
            JSONObject weatherForecastCaseMain = weatherForecastCase.getJSONObject("main");
            weatherForecast.setPressure(weatherForecastCaseMain.getDouble("pressure"));
            weatherForecast.setHumidity(weatherForecastCaseMain.getInt("humidity"));
            JSONObject weatherForecastCaseWind = weatherForecastCase.getJSONObject("wind");
            weatherForecast.setWindSpeed(weatherForecastCaseWind.getDouble("speed"));
            weatherForecast.setWindDegree(weatherForecastCaseWind.getDouble("deg"));
            JSONObject weatherForecastCaseClouds = weatherForecastCase.getJSONObject("clouds");
            weatherForecast.setCloudiness(weatherForecastCaseClouds.getInt("all"));

            if (weatherForecastCase.has("rain")) {
                JSONObject rain = weatherForecastCase.getJSONObject("rain");
                if (rain.has("3h")) {
                    weatherForecast.setRain(rain.getDouble("3h"));
                }
            } else {
                weatherForecast.setRain(0);
            }
            if (weatherForecastCase.has("snow")) {
                JSONObject snow = weatherForecastCase.getJSONObject("snow");
                if (snow.has("3h")) {
                    weatherForecast.setSnow(snow.getDouble("3h"));
                }
            } else {
                weatherForecast.setSnow(0);
            }
            weatherForecast.setTemperatureMin(weatherForecastCaseMain.getDouble("temp_min"));
            weatherForecast.setTemperatureMax(weatherForecastCaseMain.getDouble("temp_max"));
            weatherForecast.setTemperature(weatherForecastCaseMain.getDouble("temp"));
            JSONArray weatherConditionList = weatherForecastCase.getJSONArray("weather");
            for (int weatherConditionCounter = 0; weatherConditionCounter < weatherConditionList.length(); weatherConditionCounter++) {
                JSONObject weatherCondition = weatherConditionList.getJSONObject(weatherConditionCounter);
                weatherForecast.addWeatherCondition(weatherCondition.getInt("id"),
                                                    weatherCondition.getString("icon"),
                                                    weatherCondition.getString("description"));
            }
            completeWeatherForecast.addDetailedWeatherForecast(weatherForecast);
        }
        return completeWeatherForecast;
    }

