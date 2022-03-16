    @Override
    public void setViewPager(ViewPager ViewPager) {
        if (mViewPager == ViewPager) {
            return;
        }
        if (mViewPager != null) {
            //Clear us from the old pager.
            mViewPager.setOnPageChangeListener(null);
        }
        if (ViewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        mViewPager = ViewPager;
        mViewPager.setOnPageChangeListener(this);
        invalidate();
        post(new Runnable() {
            @Override public void run() {
                if (mFades) {
                    post(mFadeRunnable);
                }
            }
        });
    }

