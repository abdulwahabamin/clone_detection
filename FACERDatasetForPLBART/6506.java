    /**
     * Gather roots from all known storage providers.
     */
    public void updateAsync() {
        // Special root for recents
        mRecentsRoot.authority = null;
        mRecentsRoot.rootId = null;
        mRecentsRoot.icon = R.drawable.ic_root_recent;
        mRecentsRoot.flags = Root.FLAG_LOCAL_ONLY | Root.FLAG_SUPPORTS_CREATE;
        mRecentsRoot.title = mContext.getString(R.string.root_recent);
        mRecentsRoot.availableBytes = -1;

        new UpdateTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

