    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
        if (jumpToTheTopOfList()) {
            ListView listView = getListView();
            if (listView != null) {
                listView.setSelection(0);
            }
        }
    }

