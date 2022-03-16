    /**
     * Sets the length of each of the current child animations of this AnimatorSet. By default,
     * each child animation will use its own duration. If the duration is set on the AnimatorSet,
     * then each child animation inherits this duration.
     *
     * @param duration The length of the animation, in milliseconds, of each of the child
     * animations of this AnimatorSet.
     */
    @Override
    public AnimatorSet setDuration(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        for (Node node : mNodes) {
            // TODO: don't set the duration of the timing-only nodes created by AnimatorSet to
            // insert "play-after" delays
            node.animation.setDuration(duration);
        }
        mDuration = duration;
        return this;
    }

