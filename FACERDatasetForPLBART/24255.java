    @Override
    protected CursorAdapter createListAdapter() {
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapterWithContextMenu(
                getActivity(),
                R.layout.track_list_item,
                null,
                cols,
                new int[] { R.id.line1, R.id.line2, R.id.play_indicator },
                0);

        listAdapter.setViewBinder((view, cursor, columnIndex) -> {
            switch (view.getId()) {
                case R.id.line2:
                    int numSongs = cursor.getInt(columnIndex);
                    ((TextView) view).setText(FolderFragment.this.getActivity().getResources()
                            .getQuantityString(R.plurals.Nsongs, numSongs, numSongs));
                    return true;

                case R.id.play_indicator:
                    String folder = cursor.getString(columnIndex);

                    File currentFolder = (MusicUtils.sService != null)
                            ? MusicUtils.sService.getFolder()
                            : null;

                    if (currentFolder != null && currentFolder.getAbsolutePath().equals(folder)) {
                        view.setVisibility(View.VISIBLE);
                    } else {
                        view.setVisibility(View.INVISIBLE);
                    }
                    return true;

                default:
                    return false;
            }
        });

        return listAdapter;
    }

