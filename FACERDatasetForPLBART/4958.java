    /**
     * Get the optional double value associated with an index. The defaultValue
     * is returned if there is no value for the index, or if the value is not a
     * number and cannot be converted to a number.
     *
     * @param index
     *            subscript
     * @param defaultValue
     *            The default value.
     * @return The value.
     */
    public double optDouble(int index, double defaultValue) {
        try {
            return this.getDouble(index);
        } catch (Exception e) {
            return defaultValue;
        }
    }

