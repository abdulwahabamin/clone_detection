    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] cols = new String[] {
                MusicContract.Genre._ID,
                MusicContract.Genre.NAME,
                MusicContract.Genre._COUNT,
        };

        return new CursorLoader(getActivity(), MusicContract.Genre.CONTENT_URI, cols, null, null, null);
    }

