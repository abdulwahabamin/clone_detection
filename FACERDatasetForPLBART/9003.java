    /**
     * Constructor of <code>DiskUsageCommand</code>.
     *
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public DiskUsageCommand() throws InvalidCommandDefinitionException {
        super(ID_ALL, new String[]{});
        this.mDisksUsage = new ArrayList<DiskUsage>();
    }

