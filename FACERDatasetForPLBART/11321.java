    /**
     * Method that creates an executable for delete a directory.
     *
     * @param dir The absolute path to the directory to be deleted
     * @return DeleteDirExecutable A {@link DeleteDirExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    DeleteDirExecutable createDeleteDirExecutable(String dir) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

