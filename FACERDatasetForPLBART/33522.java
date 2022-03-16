    /**
     * Creates and shows a dialog with the list of found city names (so the user can choose one of
     * them).
     *
     * @param result a city search response, containing found cities and related data
     */
    private void showDialogWithSearchResults(SearchResponseForFindQuery result) {
        ArrayList<String> foundCityNames = getFoundCityNames(result);
        CitySearchResultsDialog citySearchResultsDialog = CitySearchResultsDialog
                .newInstance(foundCityNames);
        citySearchResultsDialog.show(activity.getSupportFragmentManager(),
                CITY_SEARCH_RESULTS_FRAGMENT_TAG);
    }

