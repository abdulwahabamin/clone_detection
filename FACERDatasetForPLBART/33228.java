    public static Main getMainObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject mainJsonObject = jsonObject.getJSONObject("main");
        if(mainJsonObject != null) {
            Main main = new Main();
            main.setHumidity(mainJsonObject.getString("humidity"));
            main.setPressure(mainJsonObject.getString("pressure"));
            main.setTemp(mainJsonObject.getString("temp"));
            main.setTemp_max(mainJsonObject.getString("temp_max"));
            main.setTemp_min(mainJsonObject.getString("temp_min"));
            return main;
        } else {
            return null;
        }
    }

