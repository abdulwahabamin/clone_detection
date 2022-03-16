    @Override
    public void onCreate(FragmentActivity activity, MediaBrowserCompat.MediaItem item) {
        Log.d(TAG, "onCreate:called");
        Log.i(TAG, "onCreate:mediaId="+item.getDescription().getMediaId());

        mMediaItem = item;
        mContext = activity;

        //init media browser
        // mediaid should be set before calling initMediaBrowser
        mMediaBrowserManager.setMediaId(item.getDescription().getMediaId());
        mMediaBrowserManager.initMediaBrowser(activity);

        mPlaylistsChangedDisposable = mPlaylistsChangedSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.w(TAG, "playlists changed!");
                mMediaBrowserManager.subscribeMediaBrowser();
            }
        });
    }

