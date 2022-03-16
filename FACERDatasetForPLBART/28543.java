    @Override
    protected void onPostResume() {
        super.onPostResume();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(pagerAdapter.getPageTitleForActionBar(viewPager.getCurrentItem()));
        }
    }

