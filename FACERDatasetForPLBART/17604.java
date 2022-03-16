    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh:called");
        mMvpView.stopLoading();
        if (mMediaBrowserManager.isMediaBrowserConnected()) {
            mMvpView.displayList(mMediaBrowserManager.getItemList());
        } else {
            mMediaBrowserManager.connectMediaBrowser();
        }
    }

