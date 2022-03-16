    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        mWidth = wm.getDefaultDisplay().getWidth() / 2;
        positionX = mWidth / 2 - mRadius - DisplayUtil.dip2px(mContext, 9); // 太阳图片的�?始x�??标
        positionY = mRadius; // 太阳图片的�?始y�??标
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

