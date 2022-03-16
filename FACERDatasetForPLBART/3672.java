    /**
     * Constructs and returns a PropertyValuesHolder with a given property and
     * set of int values.
     * @param property The property being animated. Should not be null.
     * @param values The values that the property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... values) {
        return new IntPropertyValuesHolder(property, values);
    }

