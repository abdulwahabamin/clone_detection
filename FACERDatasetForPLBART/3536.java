    /**
     * Gets the length of each of the child animations of this AnimatorSet. This value may
     * be less than 0, which indicates that no duration has been set on this AnimatorSet
     * and each of the child animations will use their own duration.
     *
     * @return The length of the animation, in milliseconds, of each of the child
     * animations of this AnimatorSet.
     */
    @Override
    public long getDuration() {
        return mDuration;
    }

