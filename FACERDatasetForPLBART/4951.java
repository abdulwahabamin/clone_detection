    /**
     * Determine if the value is null.
     *
     * @param index
     *            The index must be between 0 and length() - 1.
     * @return true if the value at the index is null, or if there is no value.
     */
    public boolean isNull(int index) {
        return JSONObject.NULL.equals(this.opt(index));
    }

