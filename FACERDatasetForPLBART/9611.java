    /**
     * Constructor of <code>Permissions</code>.
     *
     * @param user The permissions for the proprietary user of the filesystem object
     * @param group The permissions for the proprietary group of the filesystem object
     * @param others The permissions for the non proprietary users of the filesystem object
     */
    public Permissions(UserPermission user, GroupPermission group, OthersPermission others) {
        super();
        this.mUser = user;
        this.mGroup = group;
        this.mOthers = others;
    }

