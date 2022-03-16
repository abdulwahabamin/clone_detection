    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] cols = new String[] {
                MusicContract.Album._ID,
                MusicContract.Album.NAME,
                MusicContract.Album.COUNT,
        };

        return new CursorLoader(getActivity(), MusicContract.Album.CONTENT_URI, cols, null, null, null);
    }

