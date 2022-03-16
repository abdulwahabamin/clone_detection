    /**
     * Constructor of <code>SystemFile</code>.
     *
     * @param name The name of the object
     * @param parent The parent folder of the object
     * @param user The user proprietary of the object
     * @param group The group proprietary of the object
     * @param permissions The permissions of the object
     * @param size The size in bytes of the object
     * @param lastAccessedTime The last time that the object was accessed
     * @param lastModifiedTime The last time that the object was modified
     * @param lastChangedTime The last time that the object was changed
     */
    public SystemFile(
            String name, String parent, User user, Group group,
            Permissions permissions, long size,
            Date lastAccessedTime, Date lastModifiedTime, Date lastChangedTime) {
        super(name, parent, user, group, permissions, size,
                lastAccessedTime, lastModifiedTime, lastChangedTime);
    }

