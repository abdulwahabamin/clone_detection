    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (changed && mPager != null)
            selectTab(mPager.getCurrentItem());
    }

