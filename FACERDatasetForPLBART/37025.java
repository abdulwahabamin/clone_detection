    private List<CityEntity> parseCityList(String json) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        List<CityEntity> cityList = new ArrayList<>();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        for (JsonElement obj : jArray) {
            CityEntity cityEntity = gson.fromJson(obj, CityEntity.class);
            cityList.add(cityEntity);
        }
        return cityList;
    }

