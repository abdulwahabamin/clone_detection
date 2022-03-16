    /**
     * Put a key/value pair in the JSONObject. If the value is null,
     * then the key will be removed from the JSONObject if it is present.
     * @param key   A key string.
     * @param value An object which is the value. It should be of one of these
     *  types: Boolean, Double, Integer, JSONArray, JSONObject, Long, String,
     *  or the JSONObject.NULL object.
     * @return this.
     * @throws JSONException If the value is non-finite number
     *  or if the key is null.
     */
    public JSONObject put(String key, Object value) throws JSONException {
        String pooled;
        if (key == null) {
            throw new JSONException("Null key.");
        }
        if (value != null) {
            testValidity(value);
            pooled = (String)keyPool.get(key);
            if (pooled == null) {
                if (keyPool.size() >= keyPoolSize) {
                    keyPool = new HashMap(keyPoolSize);
                }
                keyPool.put(key, key);
            } else {
                key = pooled;
            }
            this.map.put(key, value);
        } else {
            this.remove(key);
        }
        return this;
    }

