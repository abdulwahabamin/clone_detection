    /**
     * Allows for easy toggling between a DragSortListView
     * and a regular old ListView. If enabled, items are
     * draggable, where the drag init mode determines how
     * items are lifted (see {@link setDragInitMode(int)}).
     * If disabled, items cannot be dragged.
     *
     * @param enabled Set <code>true</code> to enable list
     * item dragging
     */
    public void setDragEnabled(boolean enabled) {
        mDragEnabled = enabled;
    }

