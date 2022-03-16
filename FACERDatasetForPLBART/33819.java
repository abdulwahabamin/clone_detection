    private void adjustOnReorder() {
        final int firstPos = getFirstVisiblePosition();
        if (mSrcPos < firstPos) {
            // collapsed src item is off screen;
            // adjust the scroll after item heights have been fixed
            View v = getChildAt(0);
            int top = 0;
            if (v != null) {
                top = v.getTop();
            }
            setSelectionFromTop(firstPos - 1, top - getPaddingTop());
        }
    }

