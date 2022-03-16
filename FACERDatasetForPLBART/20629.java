    /**
     * Sets the fade in and fade out duration of the indicator; default is 150 ms.
     * <p/>
     *
     * @param millis the fade duration in milliseconds
     */
    public void setFadeDuration(long millis) {
        fadeInAnimation.setDuration(millis);
        fadeOutAnimation.setDuration(millis);
    }

