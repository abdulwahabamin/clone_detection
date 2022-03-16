    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Adapter
        mPlaylistAdapter = new PlaylistAdapter(getActivity(), R.layout.listview_items, null,
                new String[] {}, new int[] {}, 0);
        mListView.setOnCreateContextMenuListener(this);
        mListView.setAdapter(mPlaylistAdapter);
        mListView.setOnItemClickListener(this);

        getLoaderManager().initLoader(0, null, this);
    }

