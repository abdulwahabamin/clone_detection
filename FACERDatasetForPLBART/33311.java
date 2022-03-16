    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareCityList();
        getLoaderManager().initLoader(LOADER_ALL_CITY_RECORDS, null, this);
    }

