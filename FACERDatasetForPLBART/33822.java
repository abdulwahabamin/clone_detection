    public boolean stopDrag(boolean remove, float velocityX) {
        if (mFloatView != null) {
            mDragScroller.stopScrolling(true);

            if (remove) {
                removeItem(mSrcPos - getHeaderViewsCount(), velocityX);
            } else {
                if (mDropAnimator != null) {
                    mDropAnimator.start();
                } else {
                    dropFloatView();
                }
            }

            if (mTrackDragSort) {
                mDragSortTracker.stopTracking();
            }

            return true;
        } else {
            // stop failed
            return false;
        }
    }

