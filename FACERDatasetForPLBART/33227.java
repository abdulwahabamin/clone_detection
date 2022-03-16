    public static Weather[] getWeatherObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray weatherJsonArray = jsonObject.getJSONArray("weather");
        if(weatherJsonArray != null) {
            Weather[] weatherArray = new Weather[weatherJsonArray.length()];
            for (int i = 0; i < weatherJsonArray.length(); i++) {
                Weather weather = new Weather();
                JSONObject weatherJsonObject = weatherJsonArray.getJSONObject(i);
                weather.setId(weatherJsonObject.getString("id"));
                weather.setDescription(weatherJsonObject.getString("description"));
                weather.setIcon(weatherJsonObject.getString("icon"));
                weather.setMain(weatherJsonObject.getString("main"));
                weatherArray[i] = weather;
            }
            return weatherArray;
        } else {
            return null;
        }
    }

