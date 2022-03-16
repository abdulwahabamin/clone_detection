    /**
     * {@inheritDoc}
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.mRootView != null) { // the view may not be ready if we are requesting permission
            measureHeight();
        }
    }

