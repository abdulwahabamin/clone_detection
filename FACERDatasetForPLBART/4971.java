    /**
     * Append an long value. This increases the array's length by one.
     *
     * @param value
     *            A long value.
     * @return this.
     */
    public JSONArray put(long value) {
        this.put(new Long(value));
        return this;
    }

