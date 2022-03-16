    public static void addToContentProvider(ContentResolver contentResolver, String path, Long size) {
        ContentValues values = new ContentValues();
        values.put(DataCache.Columns.PATH, path);
        values.put(DataCache.Columns.SIZE, size);
        contentResolver.insert(DataCache.CONTENT_URI, values);
    }

