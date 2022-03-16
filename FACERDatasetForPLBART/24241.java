    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = createListAdapter();
        setListAdapter(adapter);

        getLoaderManager().initLoader(0, null, this);
    }

