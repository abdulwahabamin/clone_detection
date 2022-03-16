    private void stopDragging() {
        WindowManager wm = (WindowManager)mContext.getSystemService("window");
        wm.removeView(mDragView);
        mDragView = null;
        if (mDragBitmap != null) {
            mDragBitmap.recycle();
            mDragBitmap = null;
        }
    }

