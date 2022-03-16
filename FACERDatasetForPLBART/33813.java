    /**
     * Move an item, bypassing the drag-sort process. Simply calls
     * through to {@link DropListener#drop(int, int)}.
     * 
     * @param from Position to move (NOTE: headers/footers ignored!
     * this is a position in your input ListAdapter).
     * @param to Target position (NOTE: headers/footers ignored!
     * this is a position in your input ListAdapter).
     */
    public void moveItem(int from, int to) {
        if (mDropListener != null) {
            final int count = getInputAdapter().getCount();
            if (from >= 0 && from < count && to >= 0 && to < count) {
                mDropListener.drop(from, to);
            }
        }
    }

