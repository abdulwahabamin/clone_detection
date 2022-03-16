    /**
     * �??画処�?�
     * {@inheritDoc}
     */
    @Override
    protected void onDraw(Canvas canvas) {
        mPoint.setHeight(canvas.getHeight());
        mPoint.setWidth(canvas.getWidth());

        mLeftPath.reset();
        mRightPath.reset();

        //左�?�分Path�?�設定
        mLeftPath.moveTo(mPoint.getX(-0.5 * SQRT_3), mPoint.getY(1.f));
        mLeftPath.lineTo(mPoint.getY((Float) mLeftEdgeAnimator.getAnimatedValue()) + 0.7f,
                mPoint.getY((Float) mCenterEdgeAnimator.getAnimatedValue()));
        mLeftPath.lineTo(mPoint.getY((Float) mLeftEdgeAnimator.getAnimatedValue()) + 0.7f,
                mPoint.getY(-1 * (Float) mCenterEdgeAnimator.getAnimatedValue()));
        mLeftPath.lineTo(mPoint.getX(-0.5 * SQRT_3), mPoint.getY(-1.f));

        //�?��?�分Path�?�設定
        mRightPath.moveTo(mPoint.getY(-1 * (Float) mLeftEdgeAnimator.getAnimatedValue()),
                mPoint.getY((Float) mCenterEdgeAnimator.getAnimatedValue()));
        mRightPath.lineTo(mPoint.getX(0.5 * SQRT_3),
                mPoint.getY((Float) mRightEdgeAnimator.getAnimatedValue()));
        mRightPath.lineTo(mPoint.getX(0.5 * SQRT_3),
                mPoint.getY(-1 * (Float) mRightEdgeAnimator.getAnimatedValue()));
        mRightPath.lineTo(mPoint.getY(-1 * (Float) mLeftEdgeAnimator.getAnimatedValue()),
                mPoint.getY(-1 * (Float) mCenterEdgeAnimator.getAnimatedValue()));

        canvas.drawPath(mLeftPath, mPaint);
        canvas.drawPath(mRightPath, mPaint);
    }

