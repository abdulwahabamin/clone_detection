    /**
     * Method that creates the appropriate file system object.
     *
     * @param parentDir The parent directory
     * @param type The raw char type of the file system object
     * @param name The name of the object
     * @param link The real file that this symlink is point to
     * @param user The user proprietary of the object
     * @param group The group proprietary of the object
     * @param permissions The permissions of the object
     * @param size The size in bytes of the object
     * @param lastAccessedTime The last time that the object was accessed
     * @param lastModifiedTime The last time that the object was modified
     * @param lastChangedTime The last time that the object was changed
     * @return FileSystemObject The file system object reference
     * @throws ParseException If type couldn't be translate into a reference
     * file system object
     */
    private static FileSystemObject createObject(
            String parentDir, char type, String name, String link, User user,
            Group group, Permissions permissions, long size,
            Date lastAccessedTime, Date lastModifiedTime, Date lastChangedTime)
            throws ParseException {

        String parent =
                (parentDir == null && name.compareTo(FileHelper.ROOT_DIRECTORY) != 0) ?
                            FileHelper.ROOT_DIRECTORY :
                            parentDir;

        if (type == RegularFile.UNIX_ID) {
            return new RegularFile(
                    name, parent, user, group, permissions, size,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        if (type == Directory.UNIX_ID) {
            return new Directory(name, parent, user, group, permissions,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        if (type == Symlink.UNIX_ID) {
            return new Symlink(name, link, parent, user, group, permissions,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        if (type == BlockDevice.UNIX_ID) {
            return new BlockDevice(name, parent, user, group, permissions,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        if (type == CharacterDevice.UNIX_ID) {
            return new CharacterDevice(name, parent, user, group, permissions,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        if (type == NamedPipe.UNIX_ID) {
            return new NamedPipe(name, parent, user, group, permissions,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        if (type == DomainSocket.UNIX_ID) {
            return new DomainSocket(name, parent, user, group, permissions,
                    lastAccessedTime, lastModifiedTime, lastChangedTime);
        }
        throw new ParseException("no file system object", 0); //$NON-NLS-1$
    }

