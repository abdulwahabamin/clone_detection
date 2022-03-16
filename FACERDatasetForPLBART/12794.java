    /**
     * Method that copy an existing file system object.
     *
     * @param ctx The current context
     * @param files The list of files to copy
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     */
    public static void copyFileSystemObjects(
            final Context ctx,
            final List<LinkedResource> files,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {
        // Internal copy
        copyOrMoveFileSystemObjects(
                ctx,
                COPY_MOVE_OPERATION.COPY,
                files,
                onSelectionListener,
                onRequestRefreshListener);
    }

