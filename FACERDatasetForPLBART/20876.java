    /**
     * End a fake drag of the pager.
     *
     * @see #beginFakeDrag()
     * @see #fakeDragBy(float)
     */
    public void endFakeDrag() {
        if (!mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }

        final VelocityTracker velocityTracker = mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
        int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(
                velocityTracker, mActivePointerId);
        final int width = getClientWidth();
        final int scrollX = getScrollX();
        final ItemInfo ii = infoForCurrentScrollPosition();
        final int currentPage = ii.position;
        final float pageOffset = (((float) scrollX / width) - ii.offset) / ii.widthFactor;
        final int totalDelta = (int) (mLastMotionX - mInitialMotionX);
        int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity,
                totalDelta);
        setCurrentItemInternal(nextPage, true, true, initialVelocity);
        endDrag();

        mFakeDragging = false;
    }

