    public static HashMap<String, Long> selectAllToContentProvider(ContentResolver contentResolver) {
        HashMap<String, Long> hashMap = new HashMap<>();
        String[] projection = {
                DataCache.Columns.PATH,
                DataCache.Columns.SIZE,
        };
        Cursor cursor = contentResolver.query(DataCache.CONTENT_URI,
                projection,
                null,
                null,
                DataCache.Columns.PATH);
        if (cursor != null) {
            Log.d(TAG, "count: " + cursor.getCount());
            while (cursor.moveToNext()) {
                for (int i = 0; i < cursor.getColumnCount(); i = i + 2) {
                    hashMap.put(cursor.getString(i), cursor.getLong(i + 1));
                }
            }
            cursor.close();
        }
        return hashMap;
    }

