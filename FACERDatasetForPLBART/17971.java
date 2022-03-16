    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach:called");
        mMediaBrowserManager.disconnectMediaBrowser();
        mPlaylistsScrollToTopDisposable.dispose();
        mPlaylistsChangedDisposable.dispose();
    }

