    /**
     * Disables fade out for all of the confetti generated by this manager.
     *
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager disableFadeOut() {
        this.fadeOutInterpolator = null;
        return this;
    }

