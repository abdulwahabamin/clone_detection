    /**
     * Hook to configure the global paint states before any animation happens.
     *
     * @param paint the paint object that will be used to perform all draw operations.
     */
    protected void configurePaint(Paint paint) {
        paint.setAlpha(alpha);
    }

