    private int getChildHeight(int position) {
        if (position == mSrcPos) {
            return 0;
        }

        View v = getChildAt(position - getFirstVisiblePosition());

        if (v != null) {
            // item is onscreen, therefore child height is valid,
            // hence the "true"
            return getChildHeight(position, v, false);
        } else {
            // item is offscreen
            // first check cache for child height at this position
            int childHeight = mChildHeightCache.get(position);
            if (childHeight != -1) {
                return childHeight;
            }

            final ListAdapter adapter = getAdapter();
            int type = adapter.getItemViewType(position);

            // There might be a better place for checking for the following
            final int typeCount = adapter.getViewTypeCount();
            if (typeCount != mSampleViewTypes.length) {
                mSampleViewTypes = new View[typeCount];
            }

            if (type >= 0) {
                if (mSampleViewTypes[type] == null) {
                    v = adapter.getView(position, null, this);
                    mSampleViewTypes[type] = v;
                } else {
                    v = adapter.getView(position, mSampleViewTypes[type], this);
                }
            } else {
                // type is HEADER_OR_FOOTER or IGNORE
                v = adapter.getView(position, null, this);
            }

            // current child height is invalid, hence "true" below
            childHeight = getChildHeight(position, v, true);

            // cache it because this could have been expensive
            mChildHeightCache.add(position, childHeight);

            return childHeight;
        }
    }

