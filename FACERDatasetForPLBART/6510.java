    /**
     * Load roots from authorities that are in stopped state. Normal
     * {@link UpdateTask} passes ignore stopped applications.
     */
    private void loadStoppedAuthorities() {
        final ContentResolver resolver = mContext.getContentResolver();
        synchronized (mLock) {
            for (String authority : mStoppedAuthorities) {
                if (LOGD) Log.d(TAG, "Loading stopped authority " + authority);
                mRoots.putAll(authority, loadRootsForAuthority(resolver, authority));
            }
            mStoppedAuthorities.clear();
        }
    }

