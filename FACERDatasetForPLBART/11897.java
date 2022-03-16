    /**
     * Constructor of <code>ResolveLinkCommand</code>.
     *
     * @param src The file system object to read
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ResolveLinkCommand(String src) throws InvalidCommandDefinitionException {
        super(ID, src,
                (src.compareTo(FileHelper.ROOT_DIRECTORY) == 0) ?
                   FileHelper.ROOT_DIRECTORY :
                   new File(src).getParentFile().getAbsolutePath());
    }

