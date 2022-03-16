    /**
     * Set the target rotational velocity that confetti can reach during the animation. The actual
     * confetti's target rotational velocity will be
     * (targetRotationalVelocity +- [0, targetRotationalVelocityDeviation]).
     *
     * @param targetRotationalVelocity the target rotational velocity in degrees per second.
     * @param targetRotationalVelocityDeviation the deviation from target rotational velocity
     *   in degrees per second.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setTargetRotationalVelocity(float targetRotationalVelocity,
                                                       float targetRotationalVelocityDeviation) {
        this.targetRotationalVelocity = targetRotationalVelocity / 1000f;
        this.targetRotationalVelocityDeviation = targetRotationalVelocityDeviation / 1000f;
        return this;
    }

