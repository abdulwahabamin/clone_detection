    public void subscribeMediaBrowser() {
        Log.d(TAG, "subscribeMediaBrowser:called");
        if (mMediaId == null) {
            Log.i(TAG, "subscribeMediaBrowser:getting root");
            mMediaId = mMediaBrowser.getRoot();
        }

        if (mMediaId == null) {
            Log.i(TAG, "subscribeMediaBrowser:mediaId still null");
            return;
        }

        if (isMediaBrowserConnected()) {
            mMediaBrowser.unsubscribe(mMediaId, mSubscriptionCallback);
            mMediaBrowser.subscribe(mMediaId, mSubscriptionCallback);
        } else {
            Log.w(TAG, "subscribeMediaBrowser:media browser not connected");
        }
    }

