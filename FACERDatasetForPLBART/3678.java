    /**
     * Constructs and returns a PropertyValuesHolder object with the specified property and set
     * of values. These values can be of any type, but the type should be consistent so that
     * an appropriate {@link android.animation.TypeEvaluator} can be found that matches
     * the common type.
     * <p>If there is only one value, it is assumed to be the end value of an animation,
     * and an initial value will be derived, if possible, by calling the property's
     * {@link android.util.Property#get(Object)} function.
     * Also, if any value is null, the value will be filled in when the animation
     * starts in the same way. This mechanism of automatically getting null values only works
     * if the PropertyValuesHolder object is used in conjunction with
     * {@link ObjectAnimator}, since otherwise PropertyValuesHolder has
     * no way of determining what the value should be.
     * @param property The property associated with this set of values. Should not be null.
     * @param values The set of values to animate between.
     */
    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... values) {
        KeyframeSet keyframeSet = KeyframeSet.ofKeyframe(values);
        if (keyframeSet instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet) keyframeSet);
        } else if (keyframeSet instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet) keyframeSet);
        }
        else {
            PropertyValuesHolder pvh = new PropertyValuesHolder(property);
            pvh.mKeyframeSet = keyframeSet;
            pvh.mValueType = ((Keyframe)values[0]).getType();
            return pvh;
        }
    }

