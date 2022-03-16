    /**
     * For each DragSortListView Listener interface implemented by
     * <code>adapter</code>, this method calls the appropriate
     * set*Listener method with <code>adapter</code> as the argument.
     * 
     * @param adapter The ListAdapter providing data to back
     * DragSortListView.
     *
     * @see android.widget.ListView#setAdapter(android.widget.ListAdapter)
     */
    @Override
    public void setAdapter(ListAdapter adapter) {
        if (adapter != null) {
            mAdapterWrapper = new AdapterWrapper(adapter);
            adapter.registerDataSetObserver(mObserver);

            if (adapter instanceof DropListener) {
                setDropListener((DropListener) adapter);
            }
            if (adapter instanceof DragListener) {
                setDragListener((DragListener) adapter);
            }
            if (adapter instanceof RemoveListener) {
                setRemoveListener((RemoveListener) adapter);
            }
        } else {
            mAdapterWrapper = null;
        }

        super.setAdapter(mAdapterWrapper);
    }

