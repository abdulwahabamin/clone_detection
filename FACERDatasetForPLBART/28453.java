    /**
     * Start the confetti animation configured by this manager.
     *
     * @return the confetti manager itself that just started animating.
     */
    public ConfettiManager animate() {
        cleanupExistingAnimation();
        attachConfettiViewToParent();
        addNewConfetti(numInitialCount, 0);
        startNewAnimation();
        return this;
    }

