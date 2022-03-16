    /**
     * Expand the sliding pane to the anchor point if it is currently slideable.
     *
     * @return true if the pane was slideable and is now expanded/in the process of expading
     */
    public boolean anchorPanel() {
        if (mFirstLayout) {
            mSlideState = SlideState.ANCHORED;
            return true;
        } else {
            return expandPanel(mAnchorPoint);
        }
    }

