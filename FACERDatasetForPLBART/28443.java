    /**
     * Set the rotationalVelocity used by this manager. This value defines the the initial
     * rotational velocity for the generated confetti. The actual confetti's initial
     * rotational velocity will be (rotationalVelocity +- [0, rotationalVelocityDeviation]).
     *
     * @param rotationalVelocity the initial rotational velocity in degrees per second.
     * @param rotationalVelocityDeviation the deviation from initial rotational velocity in
     *   degrees per second.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setRotationalVelocity(float rotationalVelocity,
                                                 float rotationalVelocityDeviation) {
        this.rotationalVelocity = rotationalVelocity / 1000f;
        this.rotationalVelocityDeviation = rotationalVelocityDeviation / 1000f;
        return this;
    }

