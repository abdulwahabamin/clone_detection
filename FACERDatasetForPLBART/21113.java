    @Override
    public void setCurrentItem(int item) {
        if (mVelocityViewPager == null) {
            throw new IllegalStateException("VelocityViewPager has not been bound.");
        }
        mVelocityViewPager.setCurrentItem(item);
        mCurrentPage = item;
        invalidate();
    }

