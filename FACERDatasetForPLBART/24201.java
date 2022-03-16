    private void dragView(int x, int y) {
        float alpha = 1.0f;
        int width = mDragView.getWidth();
        if (x > width / 2) {
            alpha = ((float)(width - x)) / (width / 2);
        }
        mWindowParams.alpha = alpha;

        mWindowParams.x = mXOffset;
        mWindowParams.y = y - mDragPointY + mYOffset;
        mWindowManager.updateViewLayout(mDragView, mWindowParams);
    }

