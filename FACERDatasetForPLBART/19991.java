    /**
     * Cancel a drag. Calls {@link #stopDrag(boolean, boolean)} with
     * <code>true</code> as the first argument.
     */
    public void cancelDrag() {
        if (mDragState == DRAGGING) {
            mDragScroller.stopScrolling(true);
            destroyFloatView();
            clearPositions();
            adjustAllItems();

            if (mInTouchEvent) {
                mDragState = STOPPED;
            } else {
                mDragState = IDLE;
            }
        }
    }

