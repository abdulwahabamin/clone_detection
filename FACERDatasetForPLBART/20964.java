    @Override
    public void setCurrentItem(int item) {
        if (mVelocityViewPager == null) {
            throw new IllegalStateException("VelocityViewPager has not been bound.");
        }
        mSelectedIndex = item;
        mVelocityViewPager.setCurrentItem(item);

        int tabCount = mIconsLayout.getChildCount();
        for (int i = 0; i < tabCount; i++) {
            View child = mIconsLayout.getChildAt(i);
            boolean isSelected = (i == item);
            child.setSelected(isSelected);
            if (isSelected) {
                animateToIcon(item);
            }
        }
    }

