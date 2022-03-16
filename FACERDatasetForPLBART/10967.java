    @Override
    protected void onStart() {
        super.onStart();

        // Check restrictions
        if (!hasPermissions() ||
                !FileManagerApplication.checkRestrictSecondaryUsersAccess(this, mChRooted)) {
            return;
        }

        // Check that the current dir is mounted (for virtual filesystems)
        String curDir = mNavigationViews[mCurrentNavigationView].getCurrentDir();
        if (curDir != null) {
            VirtualMountPointConsole vc = VirtualMountPointConsole.getVirtualConsoleForPath(
                    mNavigationViews[mCurrentNavigationView].getCurrentDir());
            if (vc != null && !vc.isMounted()) {
                onRequestBookmarksRefresh();
                removeUnmountedHistory();
                removeUnmountedSelection();
            }

            if (mDisplayingSearchResults) {
                mDisplayingSearchResults = false;
                closeSearch();
            }
            getCurrentNavigationView().refresh(true);
        }
    }

