    /**
     * Constructs and returns a PropertyValuesHolder with a given property name and
     * set of float values.
     * @param propertyName The name of the property being animated.
     * @param values The values that the named property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    public static PropertyValuesHolder ofFloat(String propertyName, float... values) {
        return new FloatPropertyValuesHolder(propertyName, values);
    }

