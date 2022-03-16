    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String nullColumnHack = null;
        long id;
        switch (myURIMatcher.match(uri)) {
            case CITIES_ALL_ROWS:
                id = db.insert(CityTable.TABLE_CITIES, nullColumnHack, values);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        if (id > -1) {
            Uri insertedIdUri = ContentUris.withAppendedId(uri, id);
            getContext().getContentResolver().notifyChange(insertedIdUri, null);
            return insertedIdUri;
        }

        throw new SQLException("Could not insert into table for uri: " + uri);
    }

