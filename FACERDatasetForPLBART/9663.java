    /**
     * Constructor of <code>UserPermission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     */
    public UserPermission(boolean read, boolean write, boolean execute) {
        super(read, write, execute);
        this.mSetuid = false;
    }

