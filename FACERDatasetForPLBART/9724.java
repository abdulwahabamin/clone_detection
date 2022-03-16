    /**
     * Method that return the bookmark from his path
     *
     * @param contentResolver The content resolver
     * @param path The bookmark path
     * @return Bookmark The bookmark. null if no bookmark exists.
     */
    public static Bookmark getBookmark(ContentResolver contentResolver, String path) {
        final String where = Bookmark.Columns.PATH + " = ?"; //$NON-NLS-1$
        Cursor cursor = contentResolver.query(
                Bookmark.Columns.CONTENT_URI,
                Bookmark.Columns.BOOKMARK_QUERY_COLUMNS,
                where, new String[]{path}, null);
        Bookmark bookmark = null;
        try {
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    bookmark = new Bookmark(cursor);
                }
                cursor.close();
            }
        } finally {
            try {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {/**NON BLOCK**/}
        }
        return bookmark;
    }

