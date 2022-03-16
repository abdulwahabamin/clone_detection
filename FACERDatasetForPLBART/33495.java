    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase db;
        try {
            db = databaseHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = databaseHelper.getReadableDatabase();
        }

        String groupBy = null;
        String having = null;
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        switch (myURIMatcher.match(uri)) {
            case CITIES_SINGLE_ROW:
                queryBuilder.appendWhere(CityTable._ID + "=" + uri.getLastPathSegment());
                // fall through
            case CITIES_ALL_ROWS:
                queryBuilder.setTables(CityTable.TABLE_CITIES);
                break;
            case CITIES_SEARCH:
                queryBuilder.appendWhere(CityTable.COLUMN_NAME + " LIKE \"" +
                        uri.getLastPathSegment() + "%\"");
                queryBuilder.setProjectionMap(SEARCH_SUGGEST_PROJECTION_MAP);
                queryBuilder.setTables(CityTable.TABLE_CITIES);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, groupBy,
                having, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

