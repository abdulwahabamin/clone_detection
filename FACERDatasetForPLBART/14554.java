    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // AlbumAdapter
        mAlbumAdapter = new AlbumAdapter(getActivity(), R.layout.gridview_items, null,
                new String[] {}, new int[] {}, 0);
        mGridView.setOnCreateContextMenuListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setTextFilterEnabled(true);
        mGridView.setAdapter(mAlbumAdapter);

        // Important!
        getLoaderManager().initLoader(0, null, this);
    }

