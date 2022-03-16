    @Override
    public void setVelocityViewPager(VelocityViewPager view) {
        if (mVelocityViewPager == view) {
            return;
        }
        if (mVelocityViewPager != null) {
            mVelocityViewPager.setOnPageChangeListener(null);
        }
        if (view.getAdapter() == null) {
            throw new IllegalStateException("VelocityViewPager does not have adapter instance.");
        }
        mVelocityViewPager = view;
        mVelocityViewPager.setOnPageChangeListener(this);
        invalidate();
    }

