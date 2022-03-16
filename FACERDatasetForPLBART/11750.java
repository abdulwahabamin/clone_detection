    /**
     * Constructor of <code>CopyCommand</code>.
     *
     * @param src The name of the file or directory to be copied
     * @param dst The name of the file or directory in which copy the source file or directory
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public CopyCommand(String src, String dst) throws InvalidCommandDefinitionException {
        super(ID, src, dst);
        this.mDst = dst;
    }

