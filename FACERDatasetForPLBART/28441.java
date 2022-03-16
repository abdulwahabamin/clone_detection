    /**
     * Set the initialRotation used by this manager. This value defines the initial rotation in
     * degrees for the generated confetti. The actual confetti's initial rotation will be
     * (initialRotation +- [0, initialRotationDeviation]).
     *
     * @param initialRotation the initial rotation in degrees.
     * @param initialRotationDeviation the deviation from initial rotation in degrees.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setInitialRotation(int initialRotation, int initialRotationDeviation) {
        this.initialRotation = initialRotation;
        this.initialRotationDeviation = initialRotationDeviation;
        return this;
    }

