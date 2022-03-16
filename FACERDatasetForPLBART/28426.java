    /**
     * Configures how long this manager will emit new confetti after the animation starts.
     *
     * @param emissionDurationInMillis how long to emit new confetti in millis. This value can be
     *   {@link #INFINITE_DURATION} for a never-ending emission.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setEmissionDuration(long emissionDurationInMillis) {
        this.emissionDuration = emissionDurationInMillis;
        return this;
    }

