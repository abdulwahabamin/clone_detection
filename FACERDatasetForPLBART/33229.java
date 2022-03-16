    public static Wind getWindObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject windJson = jsonObject.getJSONObject("wind");
        if(windJson != null) {
            Wind wind = new Wind();
            wind.setDeg(windJson.getString("deg"));
            wind.setSpeed(windJson.getString("speed"));
            return wind;
        } else {
            return null;
        }
    }

