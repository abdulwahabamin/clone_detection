    /**
     * Constructor of <code>ListCommand</code>. List mode.
     *
     * @param src The file system object to be listed
     * @param mode The mode of listing
     */
    public ListCommand(SecureConsole console, String src, LIST_MODE mode) {
        super(console);
        this.mSrc = src;
        this.mMode = mode;
        this.mFiles = new ArrayList<FileSystemObject>();
    }

