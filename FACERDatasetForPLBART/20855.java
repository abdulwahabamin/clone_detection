    private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        if (oldWidth > 0 && !mItems.isEmpty()) {
            final int widthWithMargin = width - getPaddingLeft() - getPaddingRight() + margin;
            final int oldWidthWithMargin = oldWidth - getPaddingLeft() - getPaddingRight()
                    + oldMargin;
            final int xpos = getScrollX();
            final float pageOffset = (float) xpos / oldWidthWithMargin;
            final int newOffsetPixels = (int) (pageOffset * widthWithMargin);

            scrollTo(newOffsetPixels, getScrollY());
            if (!mScroller.isFinished()) {
                // We now return to your regularly scheduled scroll, already in progress.
                final int newDuration = Math.max(0, (int) (mScrollDuration - AnimationUtils.currentAnimationTimeMillis() - mScrollStartTime));
                ItemInfo targetInfo = infoForPosition(mCurItem);

                mScrollStartTime = AnimationUtils.currentAnimationTimeMillis();
                mScrollDuration = newDuration;
                mScroller.startScroll(newOffsetPixels, 0,
                        (int) (targetInfo.offset * width), 0, newDuration);
            }
        } else {
            final ItemInfo ii = infoForPosition(mCurItem);
            final float scrollOffset = ii != null ? Math.min(ii.offset, mLastOffset) : 0;
            final int scrollPos = (int) (scrollOffset *
                    (width - getPaddingLeft() - getPaddingRight()));
            if (scrollPos != getScrollX()) {
                completeScroll(false);
                scrollTo(scrollPos, getScrollY());
            }
        }
    }

