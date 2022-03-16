    /**
     * Method that opens the search view.
     *
     * @hide
     */
    void openSearch() {
        mSearchView.setVisibility(View.VISIBLE);
        mSearchView.onActionViewExpanded();
        mCustomTitleView.setVisibility(View.GONE);
    }

