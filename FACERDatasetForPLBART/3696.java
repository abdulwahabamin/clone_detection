    /**
     * Sets the name of the property that will be animated. This name is used to derive
     * a setter function that will be called to set animated values.
     * For example, a property name of <code>foo</code> will result
     * in a call to the function <code>setFoo()</code> on the target object. If either
     * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
     * also be derived and called.
     *
     * <p>Note that the setter function derived from this property name
     * must take the same parameter type as the
     * <code>valueFrom</code> and <code>valueTo</code> properties, otherwise the call to
     * the setter function will fail.</p>
     *
     * @param propertyName The name of the property being animated.
     */
    public void setPropertyName(String propertyName) {
        mPropertyName = propertyName;
    }

