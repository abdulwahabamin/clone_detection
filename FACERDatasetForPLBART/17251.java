    public void initMediaBrowser(FragmentActivity activity) {
        Log.d(TAG, "initMediaBrowser:called");
        mActivity = activity;
        Bundle bundle = null;

        // check if a list is needed
        if (mRootHint != null) {
            bundle = new Bundle();
            bundle.putString(mActivity.getResources().getString(R.string.root_hint_key), mRootHint);
        }

        mMediaBrowser = new MediaBrowserCompat(mActivity,
                new ComponentName(mActivity, MusicService.class),
                mConnectionCallbacks,
                bundle);
    }

