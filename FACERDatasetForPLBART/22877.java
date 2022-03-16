    /**
     * {@link PlayPauseButton#mBackgroundColor} ã‚’ã‚»ãƒƒãƒˆã?—ã?¦å†?æ??ç”»ã?™ã‚‹
     *
     * @param color ã‚»ãƒƒãƒˆã?™ã‚‹è‰²
     */
    public void setColor(int color) {
        mBackgroundColor = color;
        mPaint.setColor(mBackgroundColor);
        invalidate();
    }

