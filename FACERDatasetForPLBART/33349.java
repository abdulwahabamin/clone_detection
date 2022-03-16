    /**
     * Creates a new dialog with the city list.
     *
     * @param cityNames an array of city names (including location coordinates) to be
     *                  displayed as a list
     * @return a dialog displaying the list of specified city names
     */
    static CitySearchResultsDialog newInstance(ArrayList<String> cityNames) {
        CitySearchResultsDialog dialog = new CitySearchResultsDialog();
        Bundle args = new Bundle();
        args.putStringArrayList(CITY_NAME_LIST, cityNames);
        dialog.setArguments(args);
        return dialog;
    }

