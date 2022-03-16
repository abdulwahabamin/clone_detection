    /**
     * Method that creates an executable for compute the disk usage of a folder.
     *
     * @param directory The directory where to search
     * @param asyncResultListener The listener where to return partial results
     * @return FolderUsageExecutable A {@link FolderUsageExecutable} executable
     * implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    FolderUsageExecutable createFolderUsageExecutable(
            String directory, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

