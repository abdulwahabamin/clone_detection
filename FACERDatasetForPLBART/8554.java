    /**
     * Method that creates an executable for retrieve identity information of the current user.
     *
     * @param mp The mount point to mount
     * @param rw Indicates if the operation mount the device as read-write
     * @return MountExecutable A {@link MountExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    MountExecutable createMountExecutable(
            MountPoint mp, boolean rw) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

