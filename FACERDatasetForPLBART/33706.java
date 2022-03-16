    /**
     * By default, sorting is enabled, and removal is disabled.
     *
     * @param dslv The DSLV instance
     * @param dragHandleId The resource id of the View that represents
     * the drag handle in a list item.
     */
    public DragSortController(DragSortListView dslv, int dragHandleId, int dragInitMode,
            int removeMode, int clickRemoveId, int flingHandleId) {

        super(dslv);
        mDslv = dslv;
        mDetector = new GestureDetector(dslv.getContext(), this);
        mFlingRemoveDetector = new GestureDetector(dslv.getContext(), mFlingRemoveListener);
        mFlingRemoveDetector.setIsLongpressEnabled(false);
        mTouchSlop = ViewConfiguration.get(dslv.getContext()).getScaledTouchSlop();
        mDragHandleId = dragHandleId;
        mClickRemoveId = clickRemoveId;
        mFlingHandleId = flingHandleId;
        setRemoveMode(removeMode);
        setDragInitMode(dragInitMode);
    }

