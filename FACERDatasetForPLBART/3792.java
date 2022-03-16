    /**
     * Returns true if the {@link #set(Object, Object)} method does not set the value on the target
     * object (in which case the {@link #set(Object, Object) set()} method should throw a {@link
     * NoSuchPropertyException} exception). This may happen if the Property wraps functionality that
     * allows querying the underlying value but not setting it. For example, the {@link #of(Class,
     * Class, String)} factory method may return a Property with name "foo" for an object that has
     * only a <code>getFoo()</code> or <code>isFoo()</code> method, but no matching
     * <code>setFoo()</code> method.
     */
    public boolean isReadOnly() {
        return false;
    }

