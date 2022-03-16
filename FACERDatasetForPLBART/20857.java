    private int constrainScroll(int x) {
        int width = getClientWidth();

        int firstOffset = (int) (mFirstOffset * width);
        if (x < firstOffset) {
            if (ViewCompat.getOverScrollMode(this) != OVER_SCROLL_NEVER && mLeftEdge.isFinished()) {
                mLeftEdge.onAbsorb((int) Math.abs(mScroller.getCurrVelocity()));
            }

            mFlinging = FLINGING_STOPPED;
            mScroller.startScroll(firstOffset, 0, 0, 0);
            mScroller.abortAnimation();
            return firstOffset;
        }

        int lastOffset = (int) (mLastOffset * width);
        if (x > lastOffset) {
            if (ViewCompat.getOverScrollMode(this) != OVER_SCROLL_NEVER && mRightEdge.isFinished()) {
                mRightEdge.onAbsorb((int) Math.abs(mScroller.getCurrVelocity()));
            }

            mFlinging = FLINGING_STOPPED;
            mScroller.startScroll(lastOffset, 0, 0, 0);
            mScroller.abortAnimation();
            return lastOffset;
        }


        if (mFlinging != FLINGING_STOPPED) {
            int finalX = mScroller.getFinalX();
            ItemInfo snapItemInfo = infoForScrollPosition(finalX);
            int snapItemWidth = (int) (snapItemInfo.widthFactor * width);
            int snapItemOffset = (int) (snapItemInfo.offset * width);

            // infoForScrollPosition() returns the closest item. However, we can only snap when we
            // have the ItemInfo that finalX is inside of.
            if (finalX > snapItemOffset && finalX < snapItemOffset + snapItemWidth) {
                // If finalX was in the right half of the snap item, then we want to snap to the
                // next item along.
                if (finalX - snapItemOffset > snapItemWidth / 2) {
                    snapItemOffset += snapItemWidth;
                }

                if (mFlinging == FLINGING_RIGHT) {
                    if (finalX > snapItemOffset) {
                        // Overscroll
                        if (x > snapItemOffset) {
                            mFlinging = FLINGING_STOPPED;
                            int overscroll = finalX - snapItemOffset;
                            mScroller.notifyHorizontalEdgeReached(x, snapItemOffset, overscroll);
                        }
                    } else {
                        // Underscroll
                        if (x > snapItemOffset - snapItemWidth) {
                            mFlinging = FLINGING_STOPPED;
                            mScroller.notifyFinalXExtended(snapItemOffset);
                        }
                    }
                } else if (mFlinging == FLINGING_LEFT) {
                    if (finalX < snapItemOffset) {
                        // Overscroll
                        if (x < snapItemOffset) {
                            mFlinging = FLINGING_STOPPED;
                            int overscroll = snapItemOffset - finalX;
                            mScroller.notifyHorizontalEdgeReached(x, snapItemOffset, overscroll);
                        }
                    } else {
                        // Underscroll
                        if (x < snapItemOffset + snapItemWidth) {
                            mFlinging = FLINGING_STOPPED;
                            mScroller.notifyFinalXExtended(snapItemOffset);
                        }
                    }

                }
            }
        }

        return x;
    }

