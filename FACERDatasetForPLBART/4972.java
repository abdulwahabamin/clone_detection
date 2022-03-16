    /**
     * Put a value in the JSONArray, where the value will be a JSONObject which
     * is produced from a Map.
     *
     * @param value
     *            A Map value.
     * @return this.
     */
    public JSONArray put(Map value) {
        this.put(new JSONObject(value));
        return this;
    }

