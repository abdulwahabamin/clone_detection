    /**
     * Put a value in the JSONArray, where the value will be a JSONArray which
     * is produced from a Collection.
     *
     * @param index
     *            The subscript.
     * @param value
     *            A Collection value.
     * @return this.
     * @throws JSONException
     *             If the index is negative or if the value is not finite.
     */
    public JSONArray put(int index, Collection value) throws JSONException {
        this.put(index, new JSONArray(value));
        return this;
    }

