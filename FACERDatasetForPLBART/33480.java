    /**
     * Obtains the uri of the row pointed to by the provided cursor.
     */
    private Uri getRowUri(Cursor cursor) {
        int columnIndex = cursor.getColumnIndexOrThrow(CityTable._ID);
        long rowId = cursor.getLong(columnIndex);
        return getRowUri(rowId);
    }

