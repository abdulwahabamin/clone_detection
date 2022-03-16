    /**
     * Obtains the uri of the row with the given ID.
     */
    private Uri getRowUri(long rowId) {
        return ContentUris.withAppendedId(WeatherContentProvider.CONTENT_URI_CITY_RECORDS, rowId);
    }

