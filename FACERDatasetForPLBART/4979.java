    /**
     * Put a value in the JSONArray, where the value will be a JSONObject that
     * is produced from a Map.
     *
     * @param index
     *            The subscript.
     * @param value
     *            The Map value.
     * @return this.
     * @throws JSONException
     *             If the index is negative or if the the value is an invalid
     *             number.
     */
    public JSONArray put(int index, Map value) throws JSONException {
        this.put(index, new JSONObject(value));
        return this;
    }

