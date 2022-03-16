    /**
     * Method that creates an executable for calculate checksums of file system objects.
     *
     * @param src The compressed file
     * @param asyncResultListener The listener where to return partial results
     * @return ChecksumExecutable A {@link ChecksumExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ChecksumExecutable createChecksumExecutable(
            String src, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

