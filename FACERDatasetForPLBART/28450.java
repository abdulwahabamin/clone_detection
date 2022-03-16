    /**
     * Enables fade out for all of the confetti generated by this manager. Fade out means that
     * the confetti will animate alpha according to the fadeOutInterpolator according
     * to its TTL or, if TTL is not set, its bounds.
     *
     * @param fadeOutInterpolator an interpolator that interpolates animation progress [0, 1] into
     *   an alpha value [0, 1], 0 being transparent and 1 being opaque.
     * @return the confetti manager so that the set calls can be chained.
     */
    public ConfettiManager enableFadeOut(Interpolator fadeOutInterpolator) {
        this.fadeOutInterpolator = fadeOutInterpolator;
        return this;
    }

