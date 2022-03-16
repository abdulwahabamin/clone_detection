    /**
     * è¯»å?–JSONObjectæ•°æ?®
     *
     * @param key
     * @return JSONObjectæ•°æ?®
     */
    public JSONObject getAsJSONObject(String key) {
        String JSONString = getAsString(key);
        try {
            JSONObject obj = new JSONObject(JSONString);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

