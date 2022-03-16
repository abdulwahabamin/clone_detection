    /**
     * Set the accelerationY used by this manager. This value defines the Y acceleration
     * for the generated confetti. The actual confetti's Y acceleration will be
     * (accelerationY +- [0, accelerationDeviationY]). A positive Y acceleration means that the
     * confetto will be accelerating downwards.
     *
     * @param accelerationY the Y acceleration in pixels per second^2.
     * @param accelerationDeviationY the deviation from Y acceleration in pixels per second^2.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setAccelerationY(float accelerationY, float accelerationDeviationY) {
        this.accelerationY = accelerationY / 1000000f;
        this.accelerationDeviationY = accelerationDeviationY / 1000000f;
        return this;
    }

