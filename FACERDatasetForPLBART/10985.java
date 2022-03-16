    /**
     * Show the easy mode view
     */
    private void performShowEasyMode() {
        mEasyModeListView.setVisibility(View.VISIBLE);
        getCurrentNavigationView().setVisibility(View.GONE);
        performShowBackArrow(false);
    }

