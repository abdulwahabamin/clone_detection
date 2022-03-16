    /**
     * This better reorder your ListAdapter! DragSortListView does not do this
     * for you; doesn't make sense to. Make sure
     * {@link BaseAdapter#notifyDataSetChanged()} or something like it is called
     * in your implementation. Furthermore, if you have a choiceMode other than
     * none and the ListAdapter does not return true for
     * {@link ListAdapter#hasStableIds()}, you will need to call
     * {@link #moveCheckState(int, int)} to move the check boxes along with the
     * list items.
     * 
     * @param l
     */
    public void setDropListener(DropListener l) {
        mDropListener = l;
    }

