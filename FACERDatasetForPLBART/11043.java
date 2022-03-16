    /**
     * Method that removes all the history items that refers to virtual unmounted filesystems
     */
    private void removeUnmountedHistory() {
        int cc = mHistory.size() - 1;
        for (int i = cc; i >= 0; i--) {
            History history = mHistory.get(i);
            if (history.getItem() instanceof NavigationViewInfoParcelable) {
                NavigationViewInfoParcelable navigableInfo =
                        ((NavigationViewInfoParcelable) history.getItem());
                VirtualMountPointConsole vc =
                        VirtualMountPointConsole.getVirtualConsoleForPath(
                                navigableInfo.getCurrentDir());
                if (vc != null && !vc.isMounted()) {
                    mHistory.remove(i);
                    mDrawerHistory.removeViewAt(mDrawerHistory.getChildCount() - i - 1);
                }
            }
        }
        mDrawerHistoryEmpty.setVisibility(
                mDrawerHistory.getChildCount() == 0 ? View.VISIBLE : View.GONE);
        updateHistoryPositions();
    }

