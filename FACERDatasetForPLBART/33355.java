    /**
     * Creates a new adapter to map city names to the list rows.
     */
    private void initialiseRecyclerViewAdapter() {
        Bundle args = getArguments();
        ArrayList<String> cityNames = args.getStringArrayList(CITY_NAME_LIST);
        adapter = new CityNameAdapter(cityNames);
    }

