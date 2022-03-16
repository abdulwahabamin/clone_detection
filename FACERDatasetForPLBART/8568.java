    /**
     * Method that creates an executable for compress a file system object.
     *
     * @param mode The compression mode
     * @param src The file to compress
     * @param asyncResultListener The listener where to return partial results
     * @return CompressExecutable A {@link CompressExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    CompressExecutable createCompressExecutable(
            CompressionMode mode, String src, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

