    /**
     * {@inheritDoc}
     */
    @Override
    protected void onNewIntent(Intent intent) {
        // If no directory specified, restore current directory
        final String navigateTo = intent.getStringExtra(EXTRA_NAVIGATE_TO);
        final boolean restore = TextUtils.isEmpty(navigateTo);

        //Initialize navigation
        if (!hasPermissions()) {
            initNavigation(this.mCurrentNavigationView, restore, intent);
        }

        //Check the intent action
        checkIntent(intent);
    }

