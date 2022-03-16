    public void removeFavorite(int mediaId) {
        try {
            SQLiteDatabase dataBase = getWritableDatabase();
            String Query = "delete from " + AppConstant.TABLE_FAVORITES + " where " + AppConstant.MEDIA_ID + " = " + mediaId;
            dataBase.execSQL(Query);
            Log.d(TAG, Query);
        } finally {

        }
    }

