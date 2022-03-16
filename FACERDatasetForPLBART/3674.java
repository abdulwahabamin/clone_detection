    /**
     * Constructs and returns a PropertyValuesHolder with a given property and
     * set of float values.
     * @param property The property being animated. Should not be null.
     * @param values The values that the property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... values) {
        return new FloatPropertyValuesHolder(property, values);
    }

