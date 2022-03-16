    public static Sys getSysObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject sysJson = jsonObject.getJSONObject("sys");
        if(sysJson != null) {
            Sys sys = new Sys();
            sys.setId(sysJson.getString("id"));
            sys.setType(sysJson.getString("type"));
            sys.setMessage(sysJson.getString("message"));
            sys.setCountry(sysJson.getString("country"));
            sys.setSunrise(sysJson.getString("sunrise"));
            sys.setSunset(sysJson.getString("sunset"));
            return sys;
        } else {
            return null;
        }
    }

