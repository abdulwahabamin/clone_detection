    /**
     * Responsible for showing appropriate content in navigation header view ie current user
     *
     * @param headerView
     */
    private void loadNavigationHeaderView(final View headerView) {
        FireLog.d(TAG, "(++) loadNavigationHeaderView");

        if (headerView == null) {
            return;
        }

        headerBgView = (ImageView) headerView.findViewById(R.id.bgView);
    }

