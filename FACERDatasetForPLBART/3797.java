    /**
     * For given property name 'name', look for getName/isName method or 'name' field.
     * Also look for setName method (optional - could be readonly). Failing method getters and
     * field results in throwing NoSuchPropertyException.
     *
     * @param propertyHolder The class on which the methods or field are found
     * @param name The name of the property, where this name is capitalized and appended to
     * "get" and "is to search for the appropriate methods. If the get/is methods are not found,
     * the constructor will search for a field with that exact name.
     */
    public ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
         // TODO: cache reflection info for each new class/name pair
        super(valueType, name);
        char firstLetter = Character.toUpperCase(name.charAt(0));
        String theRest = name.substring(1);
        String capitalizedName = firstLetter + theRest;
        String getterName = PREFIX_GET + capitalizedName;
        try {
            mGetter = propertyHolder.getMethod(getterName, (Class<?>[]) null);
        } catch (NoSuchMethodException e) {
            try {
                /* The native implementation uses JNI to do reflection, which allows access to private methods.
                 * getDeclaredMethod(..) does not find superclass methods, so it's implemented as a fallback.
                 */
                mGetter = propertyHolder.getDeclaredMethod(getterName, (Class<?>[]) null);
                mGetter.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                // getName() not available - try isName() instead
                getterName = PREFIX_IS + capitalizedName;
                try {
                    mGetter = propertyHolder.getMethod(getterName, (Class<?>[]) null);
                } catch (NoSuchMethodException e3) {
                    try {
                        /* The native implementation uses JNI to do reflection, which allows access to private methods.
                         * getDeclaredMethod(..) does not find superclass methods, so it's implemented as a fallback.
                         */
                        mGetter = propertyHolder.getDeclaredMethod(getterName, (Class<?>[]) null);
                        mGetter.setAccessible(true);
                    } catch (NoSuchMethodException e4) {
                        // Try public field instead
                        try {
                            mField = propertyHolder.getField(name);
                            Class fieldType = mField.getType();
                            if (!typesMatch(valueType, fieldType)) {
                                throw new NoSuchPropertyException("Underlying type (" + fieldType + ") " +
                                        "does not match Property type (" + valueType + ")");
                            }
                            return;
                        } catch (NoSuchFieldException e5) {
                            // no way to access property - throw appropriate exception
                            throw new NoSuchPropertyException("No accessor method or field found for"
                                    + " property with name " + name);
                        }
                    }
                }
            }
        }
        Class getterType = mGetter.getReturnType();
        // Check to make sure our getter type matches our valueType
        if (!typesMatch(valueType, getterType)) {
            throw new NoSuchPropertyException("Underlying type (" + getterType + ") " +
                    "does not match Property type (" + valueType + ")");
        }
        String setterName = PREFIX_SET + capitalizedName;
        try {
            // mSetter = propertyHolder.getMethod(setterName, getterType);
            // The native implementation uses JNI to do reflection, which allows access to private methods.
            mSetter = propertyHolder.getDeclaredMethod(setterName, getterType);
            mSetter.setAccessible(true);
        } catch (NoSuchMethodException ignored) {
            // Okay to not have a setter - just a readonly property
        }
    }

