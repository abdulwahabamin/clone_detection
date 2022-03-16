    /**
     * Expand the sliding pane if it is currently slideable.
     *
     * @return true if the pane was slideable and is now expanded/in the process of expading
     */
    public boolean expandPanel() {
        if (mFirstLayout) {
            mSlideState = SlideState.EXPANDED;
            return true;
        } else {
            return expandPanel(1.0f);
        }
    }

