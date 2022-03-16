    private List<String> getAllFavorites() {

        Cursor cursor = null;
        List<String> mediaId = new ArrayList<String>();
        try {
            SQLiteDatabase dataBase = this.getReadableDatabase();
            cursor = dataBase.rawQuery("select " + AppConstant.MEDIA_ID + " from " + AppConstant.TABLE_FAVORITES, null);
            mediaId.clear();
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    mediaId.add(cursor.getString(cursor.getColumnIndex(AppConstant.MEDIA_ID)));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();

        }
        return mediaId;
    }

