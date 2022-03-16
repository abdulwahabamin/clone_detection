    private void adjustOnReorder() {
        final int firstPos = getFirstVisiblePosition();
        // Log.d("mobeta", "first="+firstPos+" src="+mSrcPos);
        if (mSrcPos < firstPos) {
            // collapsed src item is off screen;
            // adjust the scroll after item heights have been fixed
            View v = getChildAt(0);
            int top = 0;
            if (v != null) {
                top = v.getTop();
            }
            // Log.d("mobeta", "top="+top+" fvh="+mFloatViewHeight);
            setSelectionFromTop(firstPos - 1, top - getPaddingTop());
        }
    }

