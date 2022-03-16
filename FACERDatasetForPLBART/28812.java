    /**
     * @see android.support.v7.widget.helper.ItemTouchHelper.Callback#getMovementFlags(RecyclerView, RecyclerView.ViewHolder)
     * Sets the swipe flags for start and end.
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

