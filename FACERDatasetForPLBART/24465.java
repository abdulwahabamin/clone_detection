    @Override
    protected CursorAdapter createListAdapter() {
        return new TrackListAdapter(
                getActivity(), // need to use application context to avoid leaks
                isEditMode() ? R.layout.edit_track_list_item : R.layout.track_list_item,
                new String[]{},
                new int[]{});
    }

