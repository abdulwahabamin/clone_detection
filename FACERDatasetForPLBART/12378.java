    /**
     * Constructor of <code>Permission</code>.
     *
     * @param read If the object can be read
     * @param write If the object can be written
     * @param execute If the object can be executed
     */
    public Permission(boolean read, boolean write, boolean execute) {
        super();
        this.mRead = read;
        this.mWrite = write;
        this.mExecute = execute;
    }

