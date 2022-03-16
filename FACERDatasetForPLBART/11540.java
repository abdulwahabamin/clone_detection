    /**
     * Constructor of <code>CreateDirCommand</code>.
     *
     * @param console The current console
     * @param path The name of the new directory
     */
    public CreateDirCommand(SecureConsole console, String path) {
        super(console);
        this.mPath = path;
    }

