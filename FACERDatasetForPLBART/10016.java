    /**
     * Method that remove an existing file system object.
     *
     * @param ctx The current context
     * @param fso The file system object to remove
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @param onItemFlingerResponder The flinger responder, only if the action was initialized
     * by a flinger gesture (optional)
     */
    public static void removeFileSystemObject(
            final Context ctx, final FileSystemObject fso,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener,
            final OnItemFlingerResponder onItemFlingerResponder) {
        // Generate an array and invoke internal method
        List<FileSystemObject> files = new ArrayList<FileSystemObject>(1);
        files.add(fso);
        removeFileSystemObjects(
                ctx, files, onSelectionListener,
                onRequestRefreshListener, onItemFlingerResponder);
    }

