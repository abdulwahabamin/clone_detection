    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = new String[] {
                Audio.Genres._ID, Audio.Genres.NAME
        };
        Uri uri = Audio.Genres.EXTERNAL_CONTENT_URI;
        String sortOrder = Audio.Genres.DEFAULT_SORT_ORDER;
        return new CursorLoader(getActivity(), uri, projection, null, null, sortOrder);
    }

