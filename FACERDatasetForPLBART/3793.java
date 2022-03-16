    /**
     * Sets the value on <code>object</code> which this property represents. If the method is unable
     * to set the value on the target object it will throw an {@link UnsupportedOperationException}
     * exception.
     */
    public void set(T object, V value) {
        throw new UnsupportedOperationException("Property " + getName() +" is read-only");
    }

