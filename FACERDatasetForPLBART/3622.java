    /**
     * Constructs and returns an ObjectAnimator that animates between float values. A single
     * value implies that that value is the one being animated to. Two values imply a starting
     * and ending values. More than two values imply a starting value, values to animate through
     * along the way, and an ending value (these values will be distributed evenly across
     * the duration of the animation).
     *
     * @param target The object whose property is to be animated. This object should
     * have a public method on it called <code>setName()</code>, where <code>name</code> is
     * the value of the <code>propertyName</code> parameter.
     * @param propertyName The name of the property being animated.
     * @param values A set of values that the animation will animate between over time.
     * @return An ObjectAnimator object that is set up to animate between the given values.
     */
    public static ObjectAnimator ofFloat(Object target, String propertyName, float... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setFloatValues(values);
        return anim;
    }

