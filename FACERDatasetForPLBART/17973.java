    @Override
    public void onCreate(FragmentActivity activity) {
        Log.d(TAG, "onCreate:called");
        mContext = activity;

        //init media browser
        mMediaBrowserManager.initMediaBrowser(activity);

        mPlaylistsScrollToTopDisposable = mPlaylistsScrollToTopSubject.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                mMvpView.scrollListToTop();
            }
        });

        mPlaylistsChangedDisposable = mPlaylistsChangedSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.w(TAG, "playlists changed!");
                mMediaBrowserManager.subscribeMediaBrowser();
            }
        });
    }

