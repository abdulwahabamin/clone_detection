    /**
     * Constructor of <code>MountCommand</code>.
     *
     * @param mp The mount point to mount
     * @param rw Indicates if the operation mount the device as read-write
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public MountCommand(MountPoint mp, boolean rw) throws InvalidCommandDefinitionException {
        super(ID, false, rw ? READWRITE : READONLY, mp.getDevice(), mp.getMountPoint());
    }

