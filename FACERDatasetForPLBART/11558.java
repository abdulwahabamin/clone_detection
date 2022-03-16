    /**
     * Constructor of <code>DeleteFileCommand</code>.
     *
     * @param console The current console
     * @param path The name of the new file
     */
    public DeleteFileCommand(SecureConsole console, String path) {
        super(console);
        this.mPath = path;
    }

