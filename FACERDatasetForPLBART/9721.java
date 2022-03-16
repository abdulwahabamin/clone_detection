    /**
     * Method that removes a bookmark
     *
     * @param context The current context
     * @param bookmark The bookmark to delete
     * @return boolean If the bookmarks was remove
     */
    public static boolean removeBookmark(Context context, Bookmark bookmark) {
        // Check that has a valid information
        if (bookmark.mId == INVALID_BOOKMARKS_ID) return false;

        // Retrieve the content resolver
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = ContentUris.withAppendedId(Bookmark.Columns.CONTENT_URI, bookmark.mId);
        return contentResolver.delete(uri, "", null) == 1; //$NON-NLS-1$
    }

