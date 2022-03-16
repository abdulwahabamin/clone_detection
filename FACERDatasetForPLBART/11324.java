    /**
     * Method that creates an executable for retrieve the disk usage.
     * of the filesystem of a directory
     *
     * @param dir The absolute path to the directory
     * @return DiskUsageExecutable A {@link DiskUsageExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    DiskUsageExecutable createDiskUsageExecutable(String dir) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

