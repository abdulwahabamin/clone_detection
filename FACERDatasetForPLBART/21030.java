    @Override
    public void setVelocityViewPager(VelocityViewPager view) {
        if (mVelocityViewPager == view) {
            return;
        }
        if (mVelocityViewPager != null) {
            mVelocityViewPager.setOnPageChangeListener(null);
        }
        final PagerAdapter adapter = view.getAdapter();
        if (adapter == null) {
            throw new IllegalStateException("VelocityViewPager does not have adapter instance.");
        }
        mVelocityViewPager = view;
        view.setOnPageChangeListener(this);
        notifyDataSetChanged();
    }

