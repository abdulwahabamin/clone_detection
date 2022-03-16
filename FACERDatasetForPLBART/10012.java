    /**
     * Method that copy an existing file system object.
     *
     * @param ctx The current context
     * @param files The list of files to move
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     */
    public static void moveFileSystemObjects(
            final Context ctx,
            final List<LinkedResource> files,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {
        // Internal move
        copyOrMoveFileSystemObjects(
                ctx,
                COPY_MOVE_OPERATION.MOVE,
                files,
                onSelectionListener,
                onRequestRefreshListener);
    }

