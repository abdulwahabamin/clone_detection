    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // Log.d("mobeta", "onMeasure called");
        if (mFloatView != null) {
            if (mFloatView.isLayoutRequested()) {
                measureFloatView();
            }
            mFloatViewOnMeasured = true; // set to false after layout
        }
        mWidthMeasureSpec = widthMeasureSpec;
    }

