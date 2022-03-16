    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsDeleted = 0;
        switch (myURIMatcher.match(uri)) {
            case CITIES_SINGLE_ROW:
                String id_rec = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    rowsDeleted = db.delete(CityTable.TABLE_CITIES, CityTable._ID + "=" + id_rec,
                            null);
                } else {
                    rowsDeleted = db.delete(CityTable.TABLE_CITIES, CityTable._ID + "=" + id_rec +
                            " and " + selection, selectionArgs);
                }
                break;
            case CITIES_ALL_ROWS:
                rowsDeleted = db.delete(CityTable.TABLE_CITIES, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

