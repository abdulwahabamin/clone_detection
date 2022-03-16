    /**
     * Sets flags to restrict certain motions of the floating View
     * based on DragSortController settings (such as remove mode).
     * Starts the drag on the DragSortListView.
     *
     * @param position The list item position (includes headers).
     * @param deltaX Touch x-coord minus left edge of floating View.
     * @param deltaY Touch y-coord minus top edge of floating View.
     *
     * @return True if drag started, false otherwise.
     */
    public boolean startDrag(int position, int deltaX, int deltaY) {

        int dragFlags = 0;
        if (mSortEnabled && !mIsRemoving) {
            dragFlags |= DragSortListView.DRAG_POS_Y | DragSortListView.DRAG_NEG_Y;
        }
        if (mRemoveEnabled && mIsRemoving) {
            dragFlags |= DragSortListView.DRAG_POS_X;
            dragFlags |= DragSortListView.DRAG_NEG_X;
        }

        mDragging = mDslv.startDrag(position - mDslv.getHeaderViewsCount(), dragFlags, deltaX,
                deltaY);
        return mDragging;
    }

