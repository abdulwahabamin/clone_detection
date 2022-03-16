    /**
     * Method that creates an executable for delete a file.
     *
     * @param file The absolute path to the file to be deleted
     * @return DeleteFileExecutable A {@link DeleteFileExecutable} executable
     * implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    DeleteFileExecutable createDeleteFileExecutable(String file) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

