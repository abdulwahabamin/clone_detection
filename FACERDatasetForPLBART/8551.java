    /**
     * Method that creates a symlink of an other file system object.
     *
     * @param src The absolute path to the source fso
     * @param link The absolute path to the link fso
     * @return LinkExecutable A {@link LinkExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    LinkExecutable createLinkExecutable(
            String src, String link) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

