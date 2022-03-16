    /**
     * Method that creates an executable for uncompress file system objects.
     *
     * @param src The compressed file
     * @param dst The destination file of folder (if null this method resolve with the best
     * fit based on the src)
     * @param asyncResultListener The listener where to return partial results
     * @return UncompressExecutable A {@link UncompressExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    UncompressExecutable createUncompressExecutable(
            String src, String dst, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

