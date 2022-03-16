    /**
     * Enables the buttons contained by the list items gain focus and react to
     * clicks.
     */
    private void setListViewForClicks() {
        ListView listView = getListView();
        listView.setItemsCanFocus(true);
        listView.setFocusable(false);
        listView.setFocusableInTouchMode(false);
        listView.setClickable(false);
    }

