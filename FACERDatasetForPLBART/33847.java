    /**
     * Start a drag of item at <code>position</code> without using
     * a FloatViewManager.
     *
     * @param position Item to drag.
     * @param floatView Floating View.
     * @param dragFlags Flags that restrict some movements of the
     * floating View. For example, set <code>dragFlags |= 
     * ~{@link #DRAG_NEG_X}</code> to allow dragging the floating
     * View in all directions except off the screen to the left.
     * @param deltaX Offset in x of the touch coordinate from the
     * left edge of the floating View (i.e. touch-x minus float View
     * left).
     * @param deltaY Offset in y of the touch coordinate from the
     * top edge of the floating View (i.e. touch-y minus float View
     * top).
     *
     * @return True if the drag was started, false otherwise. This
     * <code>startDrag</code> will fail if we are not currently in
     * a touch event, <code>floatView</code> is null, or there is
     * a drag in progress.
     */
    public boolean startDrag(int position, View floatView, int dragFlags, int deltaX, int deltaY) {
        if (mDragState != IDLE || !mInTouchEvent || mFloatView != null || floatView == null
                || !mDragEnabled) {
            return false;
        }

        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }

        int pos = position + getHeaderViewsCount();
        mFirstExpPos = pos;
        mSecondExpPos = pos;
        mSrcPos = pos;
        mFloatPos = pos;

        mDragState = DRAGGING;
        mDragFlags = 0;
        mDragFlags |= dragFlags;

        mFloatView = floatView;
        measureFloatView(); // sets mFloatViewHeight

        mDragDeltaX = deltaX;
        mDragDeltaY = deltaY;

        mFloatLoc.x = mX - mDragDeltaX;
        mFloatLoc.y = mY - mDragDeltaY;

        // set src item invisible
        final View srcItem = getChildAt(mSrcPos - getFirstVisiblePosition());

        if (srcItem != null) {
            srcItem.setVisibility(View.INVISIBLE);
        }

        if (mTrackDragSort) {
            mDragSortTracker.startTracking();
        }

        // once float view is created, events are no longer passed
        // to ListView
        switch (mCancelMethod) {
            case ON_TOUCH_EVENT:
                super.onTouchEvent(mCancelEvent);
                break;
            case ON_INTERCEPT_TOUCH_EVENT:
                super.onInterceptTouchEvent(mCancelEvent);
                break;
        }

        requestLayout();

        if (mLiftAnimator != null) {
            mLiftAnimator.start();
        }

        return true;
    }

