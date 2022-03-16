    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRootView = null;

        if (mCursor!=null) {
            mCursor.close();
            mCursor = null;
        }

        onItemClickListener = null;
        mGridView = null;
        mGridViewAdapter = null;
        mContext = null;
        mHandler = null;

    }

