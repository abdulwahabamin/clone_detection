        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DragSortItemView v;
            View child;
            if (convertView != null) {
                v = (DragSortItemView) convertView;
                View oldChild = v.getChildAt(0);

                child = mAdapter.getView(position, oldChild, DragSortListView.this);
                if (child != oldChild) {
                    // shouldn't get here if user is reusing convertViews
                    // properly
                    if (oldChild != null) {
                        v.removeViewAt(0);
                    }
                    v.addView(child);
                }
            } else {
                child = mAdapter.getView(position, null, DragSortListView.this);
                if (child instanceof Checkable) {
                    v = new DragSortItemViewCheckable(getContext());
                } else {
                    v = new DragSortItemView(getContext());
                }
                v.setLayoutParams(new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                v.addView(child);
            }

            // Set the correct item height given drag state; passed
            // View needs to be measured if measurement is required.
            adjustItem(position + getHeaderViewsCount(), v, true);

            return v;
        }

