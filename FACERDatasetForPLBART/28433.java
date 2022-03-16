    /**
     * Set the accelerationX used by this manager. This value defines the X acceleration
     * for the generated confetti. The actual confetti's X acceleration will be
     * (accelerationX +- [0, accelerationDeviationX]).
     *
     * @param accelerationX the X acceleration in pixels per second^2.
     * @param accelerationDeviationX the deviation from X acceleration in pixels per second^2.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setAccelerationX(float accelerationX, float accelerationDeviationX) {
        this.accelerationX = accelerationX / 1000000f;
        this.accelerationDeviationX = accelerationDeviationX / 1000000f;
        return this;
    }

