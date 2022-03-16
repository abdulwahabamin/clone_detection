    /**
     * Constructor of <code>OthersPermission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     * @param stickybit If the object has the sticky bit active
     */
    public OthersPermission(boolean read, boolean write, boolean execute, boolean stickybit) {
        super(read, write, execute);
        this.mStickybit = stickybit;
    }

