    private void invalidateView() {
        //绘制太阳的x�??标和y�??标
        positionX = mWidth / 2 - (float) (mRadius * Math.cos((mCurrentAngle) * Math.PI / 180)) - DisplayUtil.dp2px(mContext, 10);
        positionY = mRadius - (float) (mRadius * Math.sin((mCurrentAngle) * Math.PI / 180)) + DisplayUtil.dip2px(mContext, 18);
        invalidate();
    }

