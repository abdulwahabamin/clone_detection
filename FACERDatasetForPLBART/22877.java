    /**
     * {@link PlayPauseButton#mBackgroundColor} ăă»ăăă?ă?Šć?æ??ç»ă?ă
     *
     * @param color ă»ăăă?ăèČ
     */
    public void setColor(int color) {
        mBackgroundColor = color;
        mPaint.setColor(mBackgroundColor);
        invalidate();
    }

