    /**
     * Method that return the bookmark from his identifier
     *
     * @param contentResolver The content resolver
     * @param bookmarkId The bookmark identifier
     * @return Bookmark The bookmark. null if no bookmark exists.
     */
    public static Bookmark getBookmark(ContentResolver contentResolver, int bookmarkId) {
        Cursor cursor = contentResolver.query(
                ContentUris.withAppendedId(Bookmark.Columns.CONTENT_URI, bookmarkId),
                Bookmark.Columns.BOOKMARK_QUERY_COLUMNS,
                null, null, null);
        Bookmark bookmark = null;
        try {
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    bookmark = new Bookmark(cursor);
                }
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

