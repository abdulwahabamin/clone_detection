    /**
     * Set the target X velocity that confetti can reach during the animation. The actual confetti's
     * target X velocity will be (targetVelocityX +- [0, targetVelocityXDeviation]).
     *
     * @param targetVelocityX the target X velocity in pixels per second.
     * @param targetVelocityXDeviation  the deviation from target X velocity in pixels per second.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setTargetVelocityX(float targetVelocityX,
                                              float targetVelocityXDeviation) {
        this.targetVelocityX = targetVelocityX / 1000f;
        this.targetVelocityXDeviation = targetVelocityXDeviation / 1000f;
        return this;
    }

