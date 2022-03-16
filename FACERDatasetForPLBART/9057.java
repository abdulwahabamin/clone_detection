    /**
     * Constructor of <code>ListCommand</code>. List mode.
     *
     * @param src The file system object to be listed
     * @param console The console in which retrieve the parent directory information.
     * <code>null</code> to attach to the default console
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ListCommand(String src, ShellConsole console)
            throws InvalidCommandDefinitionException {
        // Always add backslash for list the files of the directory, instead of
        // the directory.
        super(ID_LS, new String[]{ FileHelper.addTrailingSlash(src) });

        //Initialize files to something distinct of null
        this.mFiles = new ArrayList<FileSystemObject>();
        this.mMode = LIST_MODE.DIRECTORY;

        //Retrieve parent directory information
        if (src.compareTo(FileHelper.ROOT_DIRECTORY) == 0) {
            this.mParentDir = null;
        } else {
            this.mParentDir = new File(src).getAbsolutePath();
        }
    }

