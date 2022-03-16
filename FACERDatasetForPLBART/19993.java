    private void dropFloatView() {
        // must set to avoid cancelDrag being called from the
        // DataSetObserver
        mDragState = DROPPING;

        if (mDropListener != null && mFloatPos >= 0 && mFloatPos < getCount()) {
            final int numHeaders = getHeaderViewsCount();
            mDropListener.drop(mSrcPos - numHeaders, mFloatPos - numHeaders);
        }

        destroyFloatView();

        adjustOnReorder();
        clearPositions();
        adjustAllItems();

        // now the drag is done
        if (mInTouchEvent) {
            mDragState = STOPPED;
        } else {
            mDragState = IDLE;
        }
    }

