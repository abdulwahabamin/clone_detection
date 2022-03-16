    @Override
    public void setCurrentItem(int item) {
        if (mVelocityViewPager == null) {
            throw new IllegalStateException("VelocityViewPager has not been bound.");
        }
        mSelectedTabIndex = item;
        mVelocityViewPager.setCurrentItem(item);

        final int tabCount = mTabLayout.getChildCount();
        for (int i = 0; i < tabCount; i++) {
            final View child = mTabLayout.getChildAt(i);
            final boolean isSelected = (i == item);
            child.setSelected(isSelected);
            if (isSelected) {
                animateToTab(item);
            }
        }
    }

