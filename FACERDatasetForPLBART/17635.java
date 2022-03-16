    @Override
    public void onCreate(FragmentActivity activity, MediaBrowserCompat.MediaItem item) {
        Log.d(TAG, "onCreate:called");
        Log.i(TAG, "onCreate:mediaId="+item.getDescription().getMediaId());

        mMediaItem = item;
        mContext = activity;

        Log.i(TAG, "onCreate:is mvpview null="+(mMvpView==null));

        //init media browser
        // mediaid should be set before calling initmediabrowser
        mMediaBrowserManager.setMediaId(item.getDescription().getMediaId());
        mMediaBrowserManager.initMediaBrowser(activity);

    }

