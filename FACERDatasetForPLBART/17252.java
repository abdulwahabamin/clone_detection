    public void connectMediaBrowser(){
        Log.d(TAG, "connectMediaBrowser:called");
        if (mMediaBrowser != null) {
            if (!mMediaBrowser.isConnected()) {
                mMediaBrowser.connect();
            } else {
                Log.w(TAG, "connectMediaBrowser:mMediaBrowser already connected, will not connect");
            }
        } else {
            Log.e(TAG, "connectMediaBrowser:mMediaBrowser is null, cannot connect");
        }
    }

