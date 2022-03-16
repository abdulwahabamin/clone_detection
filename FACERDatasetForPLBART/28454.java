    /**
     * Terminate the currently running animation if there is any.
     */
    public void terminate() {
        if (animator != null) {
            animator.cancel();
        }
        confettiView.terminate();
    }

