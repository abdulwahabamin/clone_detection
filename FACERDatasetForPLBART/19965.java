    /**
     * Get the shuffle edge for item at position when top of
     * item is at y-coord top. Assumes that current item heights
     * are consistent with current float view location and
     * thus expanded positions and slide fraction. i.e. Should not be
     * called between update of expanded positions/slide fraction
     * and layoutChildren.
     *
     * @param position 
     * @param top
     * @param height Height of item at position. If -1, this function
     * calculates this height.
     *
     * @return Shuffle line between position-1 and position (for
     * the given view of the list; that is, for when top of item at
     * position has y-coord of given `top`). If
     * floating View (treated as horizontal line) is dropped
     * immediately above this line, it lands in position-1. If
     * dropped immediately below this line, it lands in position.
     */
    private int getShuffleEdge(int position, int top) {

        final int numHeaders = getHeaderViewsCount();
        final int numFooters = getFooterViewsCount();

        // shuffle edges are defined between items that can be
        // dragged; there are N-1 of them if there are N draggable
        // items.

        if (position <= numHeaders || (position >= getCount() - numFooters)) {
            return top;
        }

        int divHeight = getDividerHeight();

        int edge;

        int maxBlankHeight = mFloatViewHeight - mItemHeightCollapsed;
        int childHeight = getChildHeight(position);
        int itemHeight = getItemHeight(position);

        // first calculate top of item given that floating View is
        // centered over src position
        int otop = top;
        if (mSecondExpPos <= mSrcPos) {
            // items are expanded on and/or above the source position

            if (position == mSecondExpPos && mFirstExpPos != mSecondExpPos) {
                if (position == mSrcPos) {
                    otop = top + itemHeight - mFloatViewHeight;
                } else {
                    int blankHeight = itemHeight - childHeight;
                    otop = top + blankHeight - maxBlankHeight;
                }
            } else if (position > mSecondExpPos && position <= mSrcPos) {
                otop = top - maxBlankHeight;
            }

        } else {
            // items are expanded on and/or below the source position

            if (position > mSrcPos && position <= mFirstExpPos) {
                otop = top + maxBlankHeight;
            } else if (position == mSecondExpPos && mFirstExpPos != mSecondExpPos) {
                int blankHeight = itemHeight - childHeight;
                otop = top + blankHeight;
            }
        }

        // otop is set
        if (position <= mSrcPos) {
            edge = otop + (mFloatViewHeight - divHeight - getChildHeight(position - 1)) / 2;
        } else {
            edge = otop + (childHeight - divHeight - mFloatViewHeight) / 2;
        }

        return edge;
    }

