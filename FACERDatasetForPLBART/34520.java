    public HeCitiesIniter(String json) throws JSONException {
        //TODO 并�?一定�?次程�?�?�动都去�?始化，若数�?�库已存在�?试更新数�?�库
        cityDatas = new ArrayList<>(1000);
        JSONArray citiesJsonArray = new JSONObject(json).getJSONArray(CITY_INFO);

        for(int i = 0;i<citiesJsonArray.length();i++){
            JSONObject cityJsonObject = citiesJsonArray.getJSONObject(i);
            CityData cityData = new CityData();
            cityData.cityName = cityJsonObject.getString("city");
            cityData.cntyName = cityJsonObject.getString("cnty");
            cityData.city_id = cityJsonObject.getString("id");
            cityData.lat = cityJsonObject.getString("lat");
            cityData.lon = cityJsonObject.getString("lon");
            cityData.prov = cityJsonObject.getString("prov");
            cityDatas.add(cityData);
        }
    }

