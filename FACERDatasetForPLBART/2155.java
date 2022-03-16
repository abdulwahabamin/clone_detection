    @Override
    protected void onDestroy() {
        viewPager.removeAllViews();
        viewPager.setAdapter(null);
        super.onDestroy();
    }

