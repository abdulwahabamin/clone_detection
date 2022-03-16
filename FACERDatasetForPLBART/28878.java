    /**
     * @see IDataExtractor#wasCityFound(String)
     */
    @Override
    public boolean wasCityFound(String data) {
        try {
            JSONObject json = new JSONObject(data);
            return json.has("cod") && (json.getInt("cod") == 200);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

