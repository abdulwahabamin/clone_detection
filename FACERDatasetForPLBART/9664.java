    /**
     * Constructor of <code>UserPermission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     * @param setuid If the object has the setuid bit active
     */
    public UserPermission(boolean read, boolean write, boolean execute, boolean setuid) {
        super(read, write, execute);
        this.mSetuid = setuid;
    }

