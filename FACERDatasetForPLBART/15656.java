    public void setAdapter(TabAdapter adapter) {
        this.mAdapter = adapter;

        if (mPager != null && mAdapter != null)
            initTabs();
    }

