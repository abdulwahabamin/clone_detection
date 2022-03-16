    /**
     * Constructs a Keyframe object with the given time and value. The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     * @param value The value that the object will animate to as the animation time approaches
     * the time in this keyframe, and the the value animated from as the time passes the time in
     * this keyframe.
     */
    public static Keyframe ofFloat(float fraction, float value) {
        return new FloatKeyframe(fraction, value);
    }

