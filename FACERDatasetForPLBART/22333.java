    /**
     * Hides the sliding panel entirely.
     */
    public void hidePanel() {
        if (mFirstLayout) {
            mSlideState = SlideState.HIDDEN;
        } else {
            if (mSlideState == SlideState.DRAGGING || mSlideState == SlideState.HIDDEN) return;
            int newTop = computePanelTopPosition(0.0f) + (mIsSlidingUp ? +mPanelHeight : -mPanelHeight);
            smoothSlideTo(computeSlideOffset(newTop), 0);
        }
    }

