    /**
     * è¯»å?–JSONArrayæ•°æ?®
     *
     * @param key
     * @return JSONArrayæ•°æ?®
     */
    public JSONArray getAsJSONArray(String key) {
        String JSONString = getAsString(key);
        try {
            JSONArray obj = new JSONArray(JSONString);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

