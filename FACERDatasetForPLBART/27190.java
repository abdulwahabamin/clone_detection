    @Override
    public void onResume() {
        super.onResume();
        viewPagerAdapter.clear();
        tabLayout.setVisibility(View.VISIBLE);
        if (!waitAnimations) {
            loadContent();
        }
    }

