    /**
     * Private utility constructor that initializes the target object and property being animated.
     *
     * @param target The object whose property is to be animated.
     * @param property The property being animated.
     */
    private <T> ObjectAnimator(T target, Property<T, ?> property) {
        mTarget = target;
        setProperty(property);
    }

