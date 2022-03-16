    /**
     * Prepares the list view to load and display data.
     */
    private void prepareCityList() {
        cursorAdapter = getCityCursorAdapter();
        setListAdapter(cursorAdapter);
        setListViewForClicks();
    }

