    /**
     * Constructor of <code>FileSystemObject</code>.
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
    public FileSystemObject(String name, String parent, User user, Group group,
            Permissions permissions, long size,
            Date lastAccessedTime, Date lastModifiedTime, Date lastChangedTime) {
        super();
        this.mName = name;
        this.mParent = parent;
        this.mUser = user;
        this.mGroup = group;
        this.mPermissions = permissions;
        this.mSize = size;
        this.mLastAccessedTime = lastAccessedTime;
        this.mLastModifiedTime = lastModifiedTime;
        this.mLastChangedTime = lastChangedTime;
        this.mResourceIconId = RESOURCE_ICON_DEFAULT;
        this.mIsSecure = false;
        this.mIsRemote = false;
    }

