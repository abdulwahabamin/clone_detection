    /**
     * Sets the panel offset when collapsed so you can exit
     * the boundaries of the top of the screen
     *
     * @param val Offset in pixels
     */
    public void setSlidePanelOffset(int val) {
        mSlidePanelOffset = val;
        requestLayout();
    }

