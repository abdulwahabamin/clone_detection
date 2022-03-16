    @Override
    public void onCreate(FragmentActivity activity) {
        Log.d(TAG, "onCreate:called");
        mContext = activity;
        mMediaBrowserManager.initMediaBrowser(activity);
    }

