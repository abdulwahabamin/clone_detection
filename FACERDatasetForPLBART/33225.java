    public static Coord getCoordObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject coordJson = jsonObject.getJSONObject("coord");
        if(coordJson != null) {
            Coord coord = new Coord();
            coord.setLon(coordJson.getString("lon"));
            coord.setLat(coordJson.getString("lat"));
            return coord;
        } else {
            return null;
        }
    }

