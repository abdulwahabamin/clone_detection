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
    }

