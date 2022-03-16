    /**
     * Append a double value. This increases the array's length by one.
     *
     * @param value
     *            A double value.
     * @throws JSONException
     *             if the value is not finite.
     * @return this.
     */
    public JSONArray put(double value) throws JSONException {
        Double d = new Double(value);
        JSONObject.testValidity(d);
        this.put(d);
        return this;
    }

