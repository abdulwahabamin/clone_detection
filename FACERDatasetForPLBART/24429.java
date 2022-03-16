    @Override
    protected CursorAdapter createListAdapter() {
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapterWithContextMenu(
                getActivity(),
                R.layout.track_list_item,
                null,
                new String[] { MusicContract.Playlist.NAME, MusicContract.Playlist._COUNT },
                new int[] { R.id.line1, R.id.line2 },
                0);

        listAdapter.setViewBinder((view, cursor, columnIndex) -> {
            switch (view.getId()) {
                case R.id.line2:
                    int numSongs = cursor.getInt(columnIndex);
                    ((TextView) view).setText(PlaylistFragment.this.getActivity().getResources()
                            .getQuantityString(R.plurals.Nsongs, numSongs, numSongs));
                    return true;

                default:
                    return false;
            }
        });

        return listAdapter;
    }

