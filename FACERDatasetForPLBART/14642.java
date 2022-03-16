    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Adapter
        mRecentlyAddedAdapter = new RecentlyAddedAdapter(getActivity(), R.layout.listview_items,
                null, new String[] {}, new int[] {}, 0);
        mListView.setOnCreateContextMenuListener(this);
        mListView.setAdapter(mRecentlyAddedAdapter);
        mListView.setOnItemClickListener(this);

        // Important!
        getLoaderManager().initLoader(0, null, this);
    }

