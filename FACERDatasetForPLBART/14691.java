    public void setViewPager(ViewPager pager) {
        this.mPager = pager;
        mPager.setOnPageChangeListener(this);

        if (mPager != null && mAdapter != null)
            initTabs();
    }

