    protected void initNightView(int layoutID) {
        mNightViewParam = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);
        if (mNightView == null) {
            mNightView = LayoutInflater.from(this).inflate(layoutID, null);
            mWindowManager.addView(mNightView, mNightViewParam);
        }
    }

