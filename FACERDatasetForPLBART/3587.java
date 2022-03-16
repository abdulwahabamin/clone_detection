    /**
     * Gets the type of keyframe. This information is used by ValueAnimator to determine the type of
     * {@link TypeEvaluator} to use when calculating values between keyframes. The type is based
     * on the type of Keyframe created.
     *
     * @return The type of the value stored in the Keyframe.
     */
    public Class getType() {
        return mValueType;
    }

