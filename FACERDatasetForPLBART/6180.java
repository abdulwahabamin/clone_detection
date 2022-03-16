    public ColumnAdapter(ListAdapter wrapped, OnItemClickListener listener) {
        mWrapped = Preconditions.checkNotNull(wrapped);
        mListener = Preconditions.checkNotNull(listener);

        if (!wrapped.areAllItemsEnabled()) {
            throw new IllegalStateException("All items must be enabled");
        }
        if (wrapped.getViewTypeCount() > 1) {
            throw new IllegalStateException("All items must be identical");
        }
    }

