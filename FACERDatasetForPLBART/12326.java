    /**
     * Constructor of <code>GroupPermission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     * @param setgid If the object has the setgid bit active
     */
    public GroupPermission(boolean read, boolean write, boolean execute, boolean setgid) {
        super(read, write, execute);
        this.mSetGid = setgid;
    }

