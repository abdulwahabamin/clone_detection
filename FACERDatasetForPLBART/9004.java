    /**
     * Constructor of <code>DiskUsageCommand</code>.
     *
     * @param dir The directory of which obtain its disk usage
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public DiskUsageCommand(String dir) throws InvalidCommandDefinitionException {
        super(ID, new String[]{dir});
        this.mDisksUsage = new ArrayList<DiskUsage>();
    }

