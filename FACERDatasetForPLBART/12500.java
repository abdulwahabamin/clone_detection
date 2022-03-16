    /**
     * Method that add a new bookmark
     *
     * @param context The current context
     * @param bookmark The bookmark to add or update
     * @return Bookmark The bookmark added
     */
    public static Bookmark addBookmark(Context context, Bookmark bookmark) {
        // Check that has a valid information
        if (bookmark.mPath == null) return null;

        // Retrieve the content resolver
        ContentResolver contentResolver = context.getContentResolver();

        // Check that the bookmarks not exists
        Bookmark b = getBookmark(contentResolver, bookmark.mPath);
        if (b != null) return b;

        // Create the content values
        ContentValues values = createContentValues(bookmark);
        Uri uri = context.getContentResolver().insert(Bookmark.Columns.CONTENT_URI, values);
        bookmark.mId = (int) ContentUris.parseId(uri);
        if (bookmark.mId == INVALID_BOOKMARKS_ID) {
            return null;
        }
        return bookmark;
    }

