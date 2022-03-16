    /**
     * @see IDataExtractor#extractRadiusSearchItemData(String)
     */
    @Override
    public RadiusSearchItem extractRadiusSearchItemData(String data) {
        try {
            JSONObject jsonData = new JSONObject(data);
            JSONObject jsonMain = jsonData.getJSONObject("main");
            JSONArray jsonWeatherArray = jsonData.getJSONArray("weather");
            JSONObject jsonWeather = new JSONObject(jsonWeatherArray.get(0).toString());
            IApiToDatabaseConversion conversion = new OwmToDatabaseConversion();

            return new RadiusSearchItem(
                    jsonData.getString("name"),
                    (float) jsonMain.getDouble("temp"),
                    conversion.convertWeatherCategory(jsonWeather.getString("id"))
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

