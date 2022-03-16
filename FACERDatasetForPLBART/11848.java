    /**
     * Constructor of <code>MountPointInfoCommand</code>.
     *
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public MountPointInfoCommand() throws InvalidCommandDefinitionException {
        super(ID, new String[]{});
        this.mMountPoints = new ArrayList<MountPoint>();
    }

