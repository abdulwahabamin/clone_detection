    /**
     * Indicates whether this keyframe has a valid value. This method is called internally when
     * an {@link ObjectAnimator} first starts; keyframes without values are assigned values at
     * that time by deriving the value for the property from the target object.
     *
     * @return boolean Whether this object has a value assigned.
     */
    public boolean hasValue() {
        return mHasValue;
    }

