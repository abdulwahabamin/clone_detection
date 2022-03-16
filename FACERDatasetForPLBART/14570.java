    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // ArtistAdapter
        mArtistAdapter = new ArtistAdapter(getActivity(), R.layout.gridview_items, null,
                new String[] {}, new int[] {}, 0);
        mGridView.setOnCreateContextMenuListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setAdapter(mArtistAdapter);
        mGridView.setTextFilterEnabled(true);

        // Important!
        getLoaderManager().initLoader(0, null, this);
    }

