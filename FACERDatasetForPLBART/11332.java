    /**
     * Method that creates an executable for list files of a directory.
     *
     * @param src The directory where to do the listing
     * @return ListExecutable A {@link ListExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @see LIST_MODE#DIRECTORY
     */
    ListExecutable createListExecutable(String src)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

