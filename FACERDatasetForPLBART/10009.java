    /**
     * Method that remove an existing file system object.
     *
     * @param ctx The current context
     * @param fso The file system object
     * @param newName The new name of the object
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     */
    public static void renameFileSystemObject(
            final Context ctx,
            final FileSystemObject fso,
            final String newName,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // Create the destination filename
        File dst = new File(fso.getParent(), newName);
        File src = new File(fso.getFullPath());

        // Create arguments
        LinkedResource linkRes = new LinkedResource(src, dst);
        List<LinkedResource> files = new ArrayList<LinkedResource>(1);
        files.add(linkRes);

        // Internal copy
        copyOrMoveFileSystemObjects(
                ctx,
                COPY_MOVE_OPERATION.RENAME,
                files,
                onSelectionListener,
                onRequestRefreshListener);
    }

