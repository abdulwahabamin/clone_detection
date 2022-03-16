    public static Clouds getCloudsObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject cloudsJson = jsonObject.getJSONObject("clouds");
        if(cloudsJson != null) {
            Clouds clouds = new Clouds();
            clouds.setAll(cloudsJson.getString("all"));
            return clouds;
        } else {
            return null;
        }
    }

