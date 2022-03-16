    /**
     * Handles the intent that was provided to custom search suggestions, as described in
     * http://developer.android.com/guide/topics/search/adding-custom-suggestions.html#HandlingIntent
     *
     * @param intent the intent that started this activity. Since this activity is searchable and
     *               "single top", a new intent will replace the old one each time the user
     *               performs a search
     */
    private void handleIntent(Intent intent) {
        final SqlOperation sqlOperation = new SqlOperation(this);
        boolean collapseSearchViewAfterHandlingIntent = true;

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            // Handle the search request
            CursorAdapter cursorAdapter = searchView.getSuggestionsAdapter();
            if (cursorAdapter != null) {
                int cityCount = cursorAdapter.getCount();
                if (cityCount == 0) {
                    collapseSearchViewAfterHandlingIntent = false;
                    showAlertDialog(R.string.dialog_title_no_cities_found);
                } else {
                    final long[] rowIds = new long[cityCount];
                    for (int i = 0; i < cityCount; i++) {
                        rowIds[i] = cursorAdapter.getItemId(i);
                    }

                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            sqlOperation.setLastOverallQueryTimeToCurrentTime(rowIds);
                        }
                    }).start();
                }
            }
        } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            // Handle a suggestions click
            final Uri data = intent.getData();
            final long rowId = Long.valueOf(data.getLastPathSegment());

            new Thread(new Runnable() {

                @Override
                public void run() {
                    sqlOperation.setLastOverallQueryTimeToCurrentTime(rowId);
                }
            }).start();
        }

        if (collapseSearchViewAfterHandlingIntent) {
            if (searchView != null) {
                searchView.onActionViewCollapsed();
            }
        }
    }

