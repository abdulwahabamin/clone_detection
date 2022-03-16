    /**
     * Removes dragged item from the list. Calls RemoveListener.
     */
    private void doRemoveItem(int which) {
        // must set to avoid cancelDrag being called from the
        // DataSetObserver
        mDragState = REMOVING;

        // end it
        if (mRemoveListener != null) {
            mRemoveListener.remove(which);
        }

        destroyFloatView();

        adjustOnReorder();
        clearPositions();

        // now the drag is done
        if (mInTouchEvent) {
            mDragState = STOPPED;
        } else {
            mDragState = IDLE;
        }
    }

