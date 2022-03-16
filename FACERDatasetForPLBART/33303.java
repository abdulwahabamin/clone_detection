    /**
     * Called when the user submits a query. Obtains the query text, and performs the primary
     * processing.
     */
    private void onNewCityQuerySubmitted() {
        String query = queryEditText.getText().toString();
        query = preProcessQueryString(query);
        if (query.length() < MINIMUM_SEARCH_QUERY_STRING_LENGTH) {
            cityQueryTextListener.showAlertDialog(R.string.dialog_title_query_too_short);
        } else {
            cityQueryTextListener.onQueryTextSubmit(query);
        }
    }

