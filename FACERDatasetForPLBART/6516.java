    /**
     * Return the requested {@link RootInfo}, but only loading the roots for the
     * requested authority. This is useful when we want to load fast without
     * waiting for all the other roots to come back.
     */
    public RootInfo getRootOneshot(String authority, String rootId) {
        synchronized (mLock) {
            RootInfo root = getRootLocked(authority, rootId);
            if (root == null) {
                mRoots.putAll(
                        authority, loadRootsForAuthority(mContext.getContentResolver(), authority));
                root = getRootLocked(authority, rootId);
            }
            return root;
        }
    }

