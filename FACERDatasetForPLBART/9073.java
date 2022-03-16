    /**
     * Constructor of <code>MoveCommand</code>.
     *
     * @param src The name of the file or directory to be moved
     * @param dst The name of the file or directory in which move the source file or directory
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public MoveCommand(String src, String dst) throws InvalidCommandDefinitionException {
        super(ID, src, dst);
        this.mSrc = src;
        this.mDst = dst;
    }

