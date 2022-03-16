    public RootInfo getRootBlocking(String authority, String rootId) {
        waitForFirstLoad();
        loadStoppedAuthorities();
        synchronized (mLock) {
            return getRootLocked(authority, rootId);
        }
    }

