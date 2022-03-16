    private int adjustScroll(int movePos, View moveItem, int oldFirstExpPos, int oldSecondExpPos) {
        int adjust = 0;

        final int childHeight = getChildHeight(movePos);

        int moveHeightBefore = moveItem.getHeight();
        int moveHeightAfter = calcItemHeight(movePos, childHeight);

        int moveBlankBefore = moveHeightBefore;
        int moveBlankAfter = moveHeightAfter;
        if (movePos != mSrcPos) {
            moveBlankBefore -= childHeight;
            moveBlankAfter -= childHeight;
        }

        int maxBlank = mFloatViewHeight;
        if (mSrcPos != mFirstExpPos && mSrcPos != mSecondExpPos) {
            maxBlank -= mItemHeightCollapsed;
        }

        if (movePos <= oldFirstExpPos) {
            if (movePos > mFirstExpPos) {
                adjust += maxBlank - moveBlankAfter;
            }
        } else if (movePos == oldSecondExpPos) {
            if (movePos <= mFirstExpPos) {
                adjust += moveBlankBefore - maxBlank;
            } else if (movePos == mSecondExpPos) {
                adjust += moveHeightBefore - moveHeightAfter;
            } else {
                adjust += moveBlankBefore;
            }
        } else {
            if (movePos <= mFirstExpPos) {
                adjust -= maxBlank;
            } else if (movePos == mSecondExpPos) {
                adjust -= moveBlankAfter;
            }
        }

        return adjust;
    }

