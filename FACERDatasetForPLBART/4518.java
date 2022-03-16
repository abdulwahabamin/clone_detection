    @Override
    public void setImageDrawable(Drawable drawable) {
        // Constrain to given size but keep aspect ratio
        bmpWidth = drawable.getIntrinsicWidth();
        bmpHeight = drawable.getIntrinsicHeight();
        mLastTouchX = mPosX = 0;
        mLastTouchY = mPosY = 0;
        setWindowSize();

        super.setImageDrawable(drawable);
    }

