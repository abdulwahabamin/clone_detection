    /**
     * Partially expand the sliding panel up to a specific offset
     *
     * @param mSlideOffset Value between 0 and 1, where 0 is completely expanded.
     * @return true if the pane was slideable and is now expanded/in the process of expanding
     */
    public boolean expandPanel(float mSlideOffset) {
        if (mSlideableView == null || mSlideState == SlideState.EXPANDED) return false;
        mSlideableView.setVisibility(View.VISIBLE);
        return expandPanel(mSlideableView, 0, mSlideOffset);
    }

