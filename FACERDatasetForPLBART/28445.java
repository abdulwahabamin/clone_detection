    /**
     * Set the rotationalAcceleration used by this manager. This value defines the the
     * acceleration of the rotation for the generated confetti. The actual confetti's rotational
     * acceleration will be (rotationalAcceleration +- [0, rotationalAccelerationDeviation]).
     *
     * @param rotationalAcceleration the rotational acceleration in degrees per second^2.
     * @param rotationalAccelerationDeviation the deviation from rotational acceleration in degrees
     *   per second^2.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager setRotationalAcceleration(float rotationalAcceleration,
                                                     float rotationalAccelerationDeviation) {
        this.rotationalAcceleration = rotationalAcceleration / 1000000f;
        this.rotationalAccelerationDeviation = rotationalAccelerationDeviation / 1000000f;
        return this;
    }

