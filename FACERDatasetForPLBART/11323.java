    /**
     * Method that creates an executable for retrieve the disk usage.
     * for all filesystems
     *
     * @return DiskUsageExecutable A {@link DiskUsageExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    DiskUsageExecutable createDiskUsageExecutable() throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

