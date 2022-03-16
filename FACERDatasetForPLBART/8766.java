    /**
     * Constructor of <code>CreateFileCommand</code>.
     *
     * @param console The current console
     * @param path The name of the new file
     */
    public CreateFileCommand(SecureConsole console, String path) {
        super(console);
        this.mPath = path;
    }

