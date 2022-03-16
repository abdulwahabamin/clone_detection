    @Override
    public void onDestroyView() {
    	super.onDestroyView();
    	mRootView = null;
    	
    	if (mCursor!=null) {
        	mCursor.close();
        	mCursor = null;
    	}
    	
    	onItemClickListener = null;
    	mListView = null;
    	mListView = null;
    	mListViewAdapter = null;
    	mContext = null;
    	mHandler = null;
    	
    }

