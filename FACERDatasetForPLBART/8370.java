    /**
     * Method that toggle the views when there are results.
     *
     * @param hasResults Indicates if there are results
     * @param showEmpty Show the empty list message
     * @hide
     */
    void toggleResults(boolean hasResults, boolean showEmpty) {
        this.mSearchListView.setVisibility(hasResults ? View.VISIBLE : View.INVISIBLE);
        this.mEmptyListMsg.setVisibility(!hasResults && showEmpty ? View.VISIBLE : View.INVISIBLE);
    }

