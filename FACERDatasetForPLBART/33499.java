    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsUpdated;
        switch (myURIMatcher.match(uri)) {
            case CITIES_SINGLE_ROW:
                String id_rec = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    rowsUpdated = db.update(CityTable.TABLE_CITIES, values, CityTable._ID + "=" +
                            id_rec, null);
                } else {
                    rowsUpdated = db.update(CityTable.TABLE_CITIES, values, CityTable._ID + "=" +
                            id_rec + " and " + selection, selectionArgs);
                }
                break;
            case CITIES_ALL_ROWS:
                rowsUpdated = db.update(CityTable.TABLE_CITIES, values, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }

