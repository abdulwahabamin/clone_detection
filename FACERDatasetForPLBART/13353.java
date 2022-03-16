    /**
     * Method that check if the file system object is a {@link Symlink} and
     * the link reference is a block device.
     *
     * @param fso The file system object to check
     * @return boolean If file system object the link reference is a block device
     */
    public static boolean isSymlinkRefBlockDevice(FileSystemObject fso) {
        if (!hasSymlinkRef(fso)) {
            return false;
        }
        return ((Symlink)fso).getLinkRef() instanceof BlockDevice;
    }

