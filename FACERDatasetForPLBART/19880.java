    /**
     * Calls {@link #DragSortController(DragSortListView, int)} with a
     * 0 drag handle id, FLING_RIGHT_REMOVE remove mode,
     * and ON_DOWN drag init. By default, sorting is enabled, and
     * removal is disabled.
     *
     * @param dslv The DSLV instance
     */
    public DragSortController(DragSortListView dslv) {
        this(dslv, 0, ON_DOWN, FLING_REMOVE);
    }

