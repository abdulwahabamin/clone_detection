    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] cols = new String[] {
                MusicContract.Artist._ID,
                MusicContract.Artist.NAME,
                MusicContract.Artist.COUNT,
        };

        return new CursorLoader(getActivity(), MusicContract.Artist.CONTENT_URI, cols, null, null, null);
    }

