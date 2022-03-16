    public void updateActionBar() {
        final ActionBar actionBar = getActionBar();

        actionBar.setDisplayShowHomeEnabled(true);

        final boolean showIndicator = !mShowAsDialog && (mState.action != ACTION_MANAGE);
        actionBar.setDisplayHomeAsUpEnabled(showIndicator);
        if (mDrawerToggle != null) {
            mDrawerToggle.setDrawerIndicatorEnabled(showIndicator);
        }

        if (isRootsDrawerOpen()) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.setIcon(new ColorDrawable());

            if (mState.action == ACTION_OPEN || mState.action == ACTION_GET_CONTENT) {
                actionBar.setTitle(R.string.title_open);
            } else if (mState.action == ACTION_CREATE) {
                actionBar.setTitle(R.string.title_save);
            } else if (mState.action == ACTION_STANDALONE) {
                actionBar.setTitle(R.string.title_standalone);
            }
        } else {
            final RootInfo root = getCurrentRoot();
            actionBar.setIcon(root != null ? root.loadIcon(this) : null);

            if (mState.stack.size() <= 1) {
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
                actionBar.setTitle(root.title);
            } else {
                mIgnoreNextNavigation = true;
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
                actionBar.setTitle(null);
                actionBar.setListNavigationCallbacks(mStackAdapter, mStackListener);
                actionBar.setSelectedNavigationItem(mStackAdapter.getCount() - 1);
            }
        }
    }

