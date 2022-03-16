    /**
     * Method that return all the bookmarks in the database
     *
     * @param contentResolver The content resolver
     * @return Cursor The bookmarks cursor
     */
    public static Cursor getAllBookmarks(ContentResolver contentResolver) {
        return contentResolver.query(
                Bookmark.Columns.CONTENT_URI,
                Bookmark.Columns.BOOKMARK_QUERY_COLUMNS,
                null, null, null);
    }

