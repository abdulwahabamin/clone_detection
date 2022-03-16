    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        final int x1 = (int) e1.getX();
        final int y1 = (int) e1.getY();
        final int x2 = (int) e2.getX();
        final int y2 = (int) e2.getY();
        final int deltaX = x2 - mItemX;
        final int deltaY = y2 - mItemY;

        if (mCanDrag && !mDragging && (mHitPos != MISS || mFlingHitPos != MISS)) {
            if (mHitPos != MISS) {
                if (mDragInitMode == ON_DRAG && Math.abs(y2 - y1) > mTouchSlop && mSortEnabled) {
                    startDrag(mHitPos, deltaX, deltaY);
                }
                else if (mDragInitMode != ON_DOWN && Math.abs(x2 - x1) > mTouchSlop 
                        && mRemoveEnabled)
                {
                    mIsRemoving = true;
                    startDrag(mFlingHitPos, deltaX, deltaY);
                }
            } else if (mFlingHitPos != MISS) {
                if (Math.abs(x2 - x1) > mTouchSlop && mRemoveEnabled) {
                    mIsRemoving = true;
                    startDrag(mFlingHitPos, deltaX, deltaY);
                } else if (Math.abs(y2 - y1) > mTouchSlop) {
                    mCanDrag = false; // if started to scroll the list then
                                      // don't allow sorting nor fling-removing
                }
            }
        }
        return false;
    }

