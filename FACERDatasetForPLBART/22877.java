    /**
     * {@link PlayPauseButton#mBackgroundColor} をセット�?��?��?�??画�?�る
     *
     * @param color セット�?�る色
     */
    public void setColor(int color) {
        mBackgroundColor = color;
        mPaint.setColor(mBackgroundColor);
        invalidate();
    }

