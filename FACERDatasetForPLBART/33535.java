    /**
     * If there is a network connection, and the user query is valid, starts the task to search the
     * cities satisfying the provided query.
     *
     * @param query a location search text provided by the user
     */
    @Override
    public void onQueryTextSubmit(String query) {
        if (MiscMethods.isUserOnline(MainActivity.this)) {
            FindCitiesQueryProcessor findCitiesQueryProcessor =
                    new FindCitiesQueryProcessor(this, query);
            URL url = findCitiesQueryProcessor.getUrlForFindCitiesQuery(this);
            if (url != null) {
                new GetAvailableCitiesTask(MainActivity.this).execute(url);
            }
        } else {
            Toast.makeText(MainActivity.this, R.string.error_message_no_connection,
                    Toast.LENGTH_SHORT).show();
        }
    }

