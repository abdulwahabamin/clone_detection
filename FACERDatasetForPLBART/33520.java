    /**
     * Handles the city search response.
     *
     * @param result a city search response, containing found cities and related data
     */
    private void dealWithSearchResponseForFindCitiesQuery(SearchResponseForFindQuery result) {
        informActivityAboutObtainedSearchResponse(result);
        showDialogWithSearchResults(result);
    }

