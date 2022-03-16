    /**
     * Constructor of <code>Identity</code>.
     *
     * @param user The user associated to the identity
     * @param group The group associated to the identity (the primary group)
     * @param groups Additional groups associated to the identity
     */
    public Identity(User user, Group group, List<Group> groups) {
        super();
        this.mUser = user;
        this.mGroup = group;
        this.mGroups = groups;
    }

