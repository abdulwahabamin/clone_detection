    /**
     * Method that creates an executable for quickly retrieve the name of directories
     * that matches a string.
     *
     * @param regexp The regular expression
     * @return ProcessIdExecutable A {@link ProcessIdExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    QuickFolderSearchExecutable createQuickFolderSearchExecutable(
            String regexp) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

