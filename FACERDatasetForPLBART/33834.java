    /**
     * Sets layout param height, gravity, and visibility  on
     * wrapped item.
     */
    private void adjustItem(int position, View v, boolean invalidChildHeight) {
        // Adjust item height
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        int height;
        if (position != mSrcPos && position != mFirstExpPos && position != mSecondExpPos) {
            height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            height = calcItemHeight(position, v, invalidChildHeight);
        }

        if (height != lp.height) {
            lp.height = height;
            v.setLayoutParams(lp);
        }

        // Adjust item gravity
        if (position == mFirstExpPos || position == mSecondExpPos) {
            if (position < mSrcPos) {
                ((DragSortItemView) v).setGravity(Gravity.BOTTOM);
            } else if (position > mSrcPos) {
                ((DragSortItemView) v).setGravity(Gravity.TOP);
            }
        }

        // Finally adjust item visibility
        int oldVis = v.getVisibility();
        int vis = View.VISIBLE;

        if (position == mSrcPos && mFloatView != null) {
            vis = View.INVISIBLE;
        }

        if (vis != oldVis) {
            v.setVisibility(vis);
        }
    }

