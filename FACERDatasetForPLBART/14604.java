    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                BaseColumns._ID, AlbumColumns.ALBUM, AlbumColumns.NUMBER_OF_SONGS,
                AlbumColumns.ARTIST
        };
        if (getArguments() != null) {
            long artistId = getArguments().getLong((BaseColumns._ID));
            Uri uri = Audio.Artists.Albums.getContentUri(EXTERNAL, artistId);
            String sortOrder = Audio.Albums.DEFAULT_SORT_ORDER;
            return new CursorLoader(getActivity(), uri, projection, null, null, sortOrder);
        }
        return null;
    }

