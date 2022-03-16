    /**
     * This factory method creates and returns a Property given the <code>class</code> and
     * <code>name</code> parameters, where the <code>"name"</code> parameter represents either:
     * <ul>
     *     <li>a public <code>getName()</code> method on the class which takes no arguments, plus an
     *     optional public <code>setName()</code> method which takes a value of the same type
     *     returned by <code>getName()</code>
     *     <li>a public <code>isName()</code> method on the class which takes no arguments, plus an
     *     optional public <code>setName()</code> method which takes a value of the same type
     *     returned by <code>isName()</code>
     *     <li>a public <code>name</code> field on the class
     * </ul>
     *
     * <p>If either of the get/is method alternatives is found on the class, but an appropriate
     * <code>setName()</code> method is not found, the <code>Property</code> will be
     * {@link #isReadOnly() readOnly}. Calling the {@link #set(Object, Object)} method on such
     * a property is allowed, but will have no effect.</p>
     *
     * <p>If neither the methods nor the field are found on the class a
     * {@link NoSuchPropertyException} exception will be thrown.</p>
     */
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

