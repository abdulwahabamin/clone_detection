    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = CityTable.COLUMN_ORDERING_VALUE + " DESC";

        CursorLoader cursorLoader = new CursorLoader(parentActivity,
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS, projection,
                selection, selectionArgs, sortOrder);
        return cursorLoader;
    }

