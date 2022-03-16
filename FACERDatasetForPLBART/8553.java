    /**
     * Method that creates an executable for retrieve information of a file
     *
     * @param src The directory where to do the listing
     * @param followSymlinks If follow the symlink
     * @return ListExecutable A {@link ListExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @see LIST_MODE#FILEINFO
     */
    ListExecutable createFileInfoExecutable(String src, boolean followSymlinks)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

