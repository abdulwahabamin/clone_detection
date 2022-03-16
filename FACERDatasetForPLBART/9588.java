    /**
     * Constructor of <code>OthersPermission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     */
    public OthersPermission(boolean read, boolean write, boolean execute) {
        super(read, write, execute);
        this.mStickybit = false;
    }

