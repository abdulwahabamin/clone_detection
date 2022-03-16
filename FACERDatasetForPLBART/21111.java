    @Override
    public void setVelocityViewPager(VelocityViewPager VelocityViewPager) {
        if (mVelocityViewPager == VelocityViewPager) {
            return;
        }
        if (mVelocityViewPager != null) {
            //Clear us from the old pager.
            mVelocityViewPager.setOnPageChangeListener(null);
        }
        if (VelocityViewPager.getAdapter() == null) {
            throw new IllegalStateException("VelocityViewPager does not have adapter instance.");
        }
        mVelocityViewPager = VelocityViewPager;
        mVelocityViewPager.setOnPageChangeListener(this);
        invalidate();
        post(new Runnable() {
            @Override public void run() {
                if (mFades) {
                    post(mFadeRunnable);
                }
            }
        });
    }

