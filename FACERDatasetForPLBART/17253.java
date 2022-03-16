    public void disconnectMediaBrowser() {
        Log.d(TAG, "disconnectMediaBrowser:called");
        if (mMediaBrowser != null) {
            if (mMediaBrowser.isConnected()) {
                if (mMediaControllerCallback != null) {
                    MediaControllerCompat
                            .getMediaController(mActivity)
                            .unregisterCallback(mMediaControllerCallback);
                }
                if (mMediaId != null) {
                    mMediaBrowser.unsubscribe(mMediaId, mSubscriptionCallback);
                }
                mMediaBrowser.disconnect();
            } else {
                Log.w(TAG, "disconnectMediaBrowser:mMediaBrowser not connected, will not disconnect");
            }
        } else {
            Log.e(TAG, "disconnectMediaBrowser:mMediaBrowser is null, cannot disconnect");
        }
    }

