    @Override
    public void onPageSelected(int position) {
        if (mSnap || mScrollState == VelocityViewPager.SCROLL_STATE_IDLE) {
            mCurrentPage = position;
            mSnapPage = position;
            invalidate();
        }

        if (mListener != null) {
            mListener.onPageSelected(position);
        }
    }

