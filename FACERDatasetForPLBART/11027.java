    /**
     * Method that returns the history size.
     */
    private void clearHistory() {
        this.mHistory.clear();
        mHistorySaved.clear();
        mDrawerHistory.removeAllViews();
        mDrawerHistoryEmpty.setVisibility(View.VISIBLE);

        // Delete all history items in the database
        deleteAllHistorys();
    }

