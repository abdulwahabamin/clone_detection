    /**
     * Constructor of <code>ListCommand</code>. FileInfo mode
     *
     * @param src The file system object to be listed
     * @param followSymlinks If follow the symlink
     * @param console The console in which retrieve the parent directory information.
     * <code>null</code> to attach to the default console
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     */
    public ListCommand(String src, boolean followSymlinks, ShellConsole console)
            throws InvalidCommandDefinitionException, FileNotFoundException, IOException {
        // Always remove backslash for avoid listing the files of the directory, instead of
        // the directory.
        super(ID_FILEINFO,
                new String[]{
                    FileHelper.removeTrailingSlash(
                            followSymlinks ?
                                    new File(src).getCanonicalPath() :
                                    new File(src).getAbsolutePath())});

        //Initialize files to something distinct of null
        this.mFiles = new ArrayList<FileSystemObject>();
        this.mMode = LIST_MODE.FILEINFO;

        //Get the absolute path
        if (followSymlinks) {
            this.mParentDir =
                    FileHelper.removeTrailingSlash(
                            new File(src).getCanonicalFile().getParent());
        } else {
            this.mParentDir =
                    FileHelper.removeTrailingSlash(
                            new File(src).getAbsoluteFile().getParent());
        }
    }

