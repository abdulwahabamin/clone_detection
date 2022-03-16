    /**
     * Removes an item from the list and animates the removal.
     *
     * @param which Position to remove (NOTE: headers/footers ignored!
     * this is a position in your input ListAdapter).
     * @param velocityX 
     */
    public void removeItem(int which, float velocityX) {
        if (mDragState == IDLE || mDragState == DRAGGING) {

            if (mDragState == IDLE) {
                // called from outside drag-sort
                mSrcPos = getHeaderViewsCount() + which;
                mFirstExpPos = mSrcPos;
                mSecondExpPos = mSrcPos;
                mFloatPos = mSrcPos;
                View v = getChildAt(mSrcPos - getFirstVisiblePosition());
                if (v != null) {
                    v.setVisibility(View.INVISIBLE);
                }
            }

            mDragState = REMOVING;
            mRemoveVelocityX = velocityX;

            if (mInTouchEvent) {
                switch (mCancelMethod) {
                    case ON_TOUCH_EVENT:
                        super.onTouchEvent(mCancelEvent);
                        break;
                    case ON_INTERCEPT_TOUCH_EVENT:
                        super.onInterceptTouchEvent(mCancelEvent);
                        break;
                }
            }

            if (mRemoveAnimator != null) {
                mRemoveAnimator.start();
            } else {
                doRemoveItem(which);
            }
        }
    }

