    public boolean isIconUniqueBlocking(RootInfo root) {
        waitForFirstLoad();
        loadStoppedAuthorities();
        synchronized (mLock) {
            final int rootIcon = root.derivedIcon != 0 ? root.derivedIcon : root.icon;
            for (RootInfo test : mRoots.get(root.authority)) {
                if (Objects.equal(test.rootId, root.rootId)) {
                    continue;
                }
                final int testIcon = test.derivedIcon != 0 ? test.derivedIcon : test.icon;
                if (testIcon == rootIcon) {
                    return false;
                }
            }
            return true;
        }
    }

