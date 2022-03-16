    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach:called");
        mQueueIndexUpdatedDisposable.dispose();
        mMediaBrowserManager.disconnectMediaBrowser();
    }

