    private int getChildHeight(int position, View item, boolean invalidChildHeight) {
        if (position == mSrcPos) {
            return 0;
        }

        View child;
        if (position < getHeaderViewsCount() || position >= getCount() - getFooterViewsCount()) {
            child = item;
        } else {
            child = ((ViewGroup) item).getChildAt(0);
        }

        ViewGroup.LayoutParams lp = child.getLayoutParams();

        if (lp != null) {
            if (lp.height > 0) {
                return lp.height;
            }
        }

        int childHeight = child.getHeight();

        if (childHeight == 0 || invalidChildHeight) {
            measureItem(child);
            childHeight = child.getMeasuredHeight();
        }

        return childHeight;
    }

