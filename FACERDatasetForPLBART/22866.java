    /**
     * Animator�?��?期化
     * �??れ�?�れ�?�Animator�?��?期値をセット�?�､start�?��?��?��?�る
     */
    private void setUpAnimator() {
        if (mPlayed) {
            mCenterEdgeAnimator = ValueAnimator.ofFloat(1.f, 1.f);
            mLeftEdgeAnimator = ValueAnimator.ofFloat((float) (-0.2f * SQRT_3), (float) (-0.2f * SQRT_3));
            mRightEdgeAnimator = ValueAnimator.ofFloat(1.f, 1.f);
        } else {
            mCenterEdgeAnimator = ValueAnimator.ofFloat(0.5f, 0.5f);
            mLeftEdgeAnimator = ValueAnimator.ofFloat(0.f, 0.f);
            mRightEdgeAnimator = ValueAnimator.ofFloat(0.f, 0.f);
        }

        mCenterEdgeAnimator.start();
        mLeftEdgeAnimator.start();
        mRightEdgeAnimator.start();
    }

