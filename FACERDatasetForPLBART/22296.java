    /**
     * @return The current paralax offset
     */
    public int getCurrentParalaxOffset() {
        if (mParallaxOffset < 0) {
            return 0;
        }

        return (int) (mParallaxOffset * getDirectionalSlideOffset());
    }

