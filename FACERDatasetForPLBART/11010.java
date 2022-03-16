    @Override
    public void onBackPressed() {
        if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawer(Gravity.START);
            return;
        }

        boolean upToParent = mHistory != null && mHistory.size() > 0;

        if (mNeedsEasyMode && !isEasyModeVisible() && !upToParent) {
            performShowEasyMode();
            return;
        } else {
            if (checkBackAction()) {
                return;
            }
        }

        // An exit event has occurred, force the destroy the consoles
        exit();
    }

