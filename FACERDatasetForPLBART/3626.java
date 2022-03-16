    /**
     * Constructs and returns an ObjectAnimator that animates between the sets of values specified
     * in <code>PropertyValueHolder</code> objects. This variant should be used when animating
     * several properties at once with the same ObjectAnimator, since PropertyValuesHolder allows
     * you to associate a set of animation values with a property name.
     *
     * @param target The object whose property is to be animated. Depending on how the
     * PropertyValuesObjects were constructed, the target object should either have the {@link
     * android.util.Property} objects used to construct the PropertyValuesHolder objects or (if the
     * PropertyValuesHOlder objects were created with property names) the target object should have
     * public methods on it called <code>setName()</code>, where <code>name</code> is the name of
     * the property passed in as the <code>propertyName</code> parameter for each of the
     * PropertyValuesHolder objects.
     * @param values A set of PropertyValuesHolder objects whose values will be animated between
     * over time.
     * @return An ObjectAnimator object that is set up to animate between the given values.
     */
    public static ObjectAnimator ofPropertyValuesHolder(Object target,
            PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.mTarget = target;
        anim.setValues(values);
        return anim;
    }

