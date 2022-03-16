    /**
     * Method that remove all orphan bookmarks derived from "path"
     *
     * @param ctx The current context
     * @param path The path to check
     */
    public static void deleteOrphanBookmarks(Context ctx, String path) {
        ContentResolver cr = ctx.getContentResolver();
        Cursor cursor = Bookmarks.getAllBookmarks(cr);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    Bookmark bm = new Bookmark(cursor);
                    if (bm.mPath.startsWith(path)) {
                        removeBookmark(ctx, bm);
                    }
                } while (cursor.moveToNext());
            }
        } finally {
            try {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

