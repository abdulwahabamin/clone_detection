    @Override
    protected CursorAdapter createListAdapter() {
        return new QueryListAdapter(
                getActivity(),
                R.layout.track_list_item,
                null, // cursor
                new String[]{},
                new int[]{});
    }

