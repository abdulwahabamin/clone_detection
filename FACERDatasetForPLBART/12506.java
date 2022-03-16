    /**
     * Method that create the {@link ContentValues} from the bookmark
     *
     * @param bookmark The bookmark
     * @return ContentValues The content
     */
    private static ContentValues createContentValues(Bookmark bookmark) {
        ContentValues values = new ContentValues(1);
        values.put(Bookmark.Columns.PATH, bookmark.mPath);
        return values;
    }

