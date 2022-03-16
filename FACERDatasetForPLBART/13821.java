    public long addFavorite(int mediaId) {

        long id = 0;
        try {
            SQLiteDatabase dataBase = getWritableDatabase();

            if (!isMediaIdAlreadyExists(dataBase, mediaId)) {
                ContentValues favContentValues = new ContentValues();
                favContentValues.put(AppConstant.MEDIA_ID, mediaId);
                id = dataBase.insertWithOnConflict(AppConstant.TABLE_FAVORITES, null, favContentValues, SQLiteDatabase.CONFLICT_REPLACE);
            } else {
                id = 0;
            }
        } finally {

        }
        return id;
    }

