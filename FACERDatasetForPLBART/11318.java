    /**
     * Method that creates an executable for copy a file system object to
     * other file system object.
     *
     * @param src The absolute path to the source file system object
     * @param dst The absolute path to the destination file system object
     * @return CopyExecutable A {@link CopyExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    CopyExecutable createCopyExecutable(String src, String dst) throws CommandNotFoundException,
    NoSuchFileOrDirectory, InsufficientPermissionsException;

