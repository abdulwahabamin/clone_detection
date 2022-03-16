    @Override
    public void onPageSelected(int position) {
        if (mScrollState == VelocityViewPager.SCROLL_STATE_IDLE) {
            mCurrentPage = position;
            invalidate();
        }

        if (mListener != null) {
            mListener.onPageSelected(position);
        }
    }

