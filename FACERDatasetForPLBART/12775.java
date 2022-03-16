    /**
     * Method that adds the {@link FileSystemObject} to the bookmarks database.
     *
     * @param ctx The current context
     * @param fso The file system object
     */
    public static Bookmark addToBookmarks(final Context ctx, final FileSystemObject fso) {
        try {
            // Check if the bookmark exists already
            if (Bookmarks.getBookmark(ctx.getContentResolver(), fso.getFullPath()) != null) {
                DialogHelper.showToast(
                        ctx,
                        R.string.bookmarks_msgs_add_exists,
                        Toast.LENGTH_SHORT);
                return null;
            }

            // Create the bookmark
            Bookmark bookmark =
                    new Bookmark(BOOKMARK_TYPE.USER_DEFINED, fso.getName(), fso.getFullPath());
            bookmark = Bookmarks.addBookmark(ctx, bookmark);
            if (bookmark == null) {
                // The operation fails
                DialogHelper.showToast(
                        ctx,
                        R.string.msgs_operation_failure,
                        Toast.LENGTH_SHORT);
                return null;
            }

            // Success
            DialogHelper.showToast(
                    ctx,
                    R.string.bookmarks_msgs_add_success,
                    Toast.LENGTH_SHORT);
            return bookmark;

        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
        return null;
    }

