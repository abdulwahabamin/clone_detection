    private boolean isMediaIdAlreadyExists(SQLiteDatabase db, int mediaId) {
        Cursor cursor = null;
        try {
            String Query = "select * from " + AppConstant.TABLE_FAVORITES + " where " + AppConstant.MEDIA_ID + " = " + mediaId;
            cursor = db.rawQuery(Query, null);
            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return false;
    }

