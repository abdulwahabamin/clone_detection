    /**
     * {@inheritDoc}
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (hasPermissions()) {
            onLayoutChanged();
            if (mDrawerToggle != null ) {
                mDrawerToggle.onConfigurationChanged(newConfig);
            }
        }
        NavigationView navView = getCurrentNavigationView();
        if (navView != null) {
            navView.refreshViewMode();
        }
        if (mPopupWindow != null) {
            mPopupWindow.postShow();
        }
    }

