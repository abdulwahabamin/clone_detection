    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach:called");
        mMediaBrowserManager.disconnectMediaBrowser();
        albumClickDisposable.dispose();
        artistClickDisposable.dispose();
        selectedItemDisposable.dispose();
        playlistClickDisposable.dispose();
        mMusicPlayerPanelDisposable.dispose();
    }

