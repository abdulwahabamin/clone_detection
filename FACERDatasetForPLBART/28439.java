    /**
     * Set the target Y velocity that confetti can reach during the animation. The actual confetti's
     * target Y velocity will be (targetVelocityY +- [0, targetVelocityYDeviation]).
     *
     * @param targetVelocityY the target Y velocity in pixels per second.
     * @param targetVelocityYDeviation  the deviation from target Y velocity in pixels per second.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setTargetVelocityY(float targetVelocityY,
                                              float targetVelocityYDeviation) {
        this.targetVelocityY = targetVelocityY / 1000f;
        this.targetVelocityYDeviation = targetVelocityYDeviation / 1000f;
        return this;
    }

