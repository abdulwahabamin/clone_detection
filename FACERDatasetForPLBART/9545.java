    /**
     * Constructor of <code>GroupPermission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     */
    public GroupPermission(boolean read, boolean write, boolean execute) {
        super(read, write, execute);
        this.mSetGid = false;
    }

