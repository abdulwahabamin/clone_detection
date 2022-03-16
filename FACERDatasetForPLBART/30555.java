    public void setScrollOffset(int offset, int maxScrollOffset) {
        this.maxScrollOffset = maxScrollOffset + DisplayUtil.dp2px(mContext, 50);
        scrollOffset = offset;
        currentItemIndex = calculateItemIndex();
        invalidate();
    }

