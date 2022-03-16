    /**
     * Passes the city search response to the activity that started this task for further
     * processing.
     *
     * @param result a city search response, containing found cities and related data
     */
    private void informActivityAboutObtainedSearchResponse(SearchResponseForFindQuery result) {
        try {
            OnCitySearchResponseRetrievedListener listener =
                    (OnCitySearchResponseRetrievedListener) activity;
            listener.onSearchResponseForFindQueryRetrieved(result);
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    " must implement OnCitySearchResponseRetrievedListener");
        }
    }

