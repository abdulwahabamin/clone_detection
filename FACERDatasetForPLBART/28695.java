    @Override
    protected void onResume() {
        super.onResume();

        viewPagerPageChangeListener.onPageSelected(viewPager.getCurrentItem());
    }

