    /**
     * Method that copy an existing file system object.
     *
     * @param ctx The current context
     * @param fso The file system object
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     */
    public static void createCopyFileSystemObject(
            final Context ctx,
            final FileSystemObject fso,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // Create a non-existing name
        String curDir = onSelectionListener.onRequestCurrentDir();
        String  newName =
                FileHelper.createNonExistingName(
                        ctx, curDir, fso.getName(), R.string.create_copy_regexp);
        final File dst = new File(fso.getParent(), newName);
        File src = new File(fso.getFullPath());

        // Create arguments
        LinkedResource linkRes = new LinkedResource(src, dst);
        List<LinkedResource> files = new ArrayList<LinkedResource>(1);
        files.add(linkRes);

        // Internal copy
        copyOrMoveFileSystemObjects(
                ctx,
                COPY_MOVE_OPERATION.CREATE_COPY,
                files,
                onSelectionListener,
                onRequestRefreshListener);
    }

