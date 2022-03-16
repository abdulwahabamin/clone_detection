    /**
     * Constructor of <code>Symlink</code>.
     *
     * @param name The name of the object
     * @param link The real file that this symlink is point to
     * @param parent The parent folder of the object
     * @param user The user proprietary of the object
     * @param group The group proprietary of the object
     * @param permissions The permissions of the object
     * @param lastAccessedTime The last time that the object was accessed
     * @param lastModifiedTime The last time that the object was modified
     * @param lastChangedTime The last time that the object was changed
     */
    public Symlink(String name, String link, String parent, User user,
            Group group, Permissions permissions,
            Date lastAccessedTime, Date lastModifiedTime, Date lastChangedTime) {
        super(name, parent, user, group, permissions, 0L,
                lastAccessedTime, lastModifiedTime, lastChangedTime);
        this.mLink = link;
    }

