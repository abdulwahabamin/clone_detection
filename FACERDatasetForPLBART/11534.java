    /**
     * Constructor of <code>CopyCommand</code>.
     *
     * @param console The current console
     * @param src The name of the file or directory to be copied
     * @param dst The name of the file or directory in which copy the source file or directory
     */
    public CopyCommand(SecureConsole console, String src, String dst) {
        super(console);
        this.mSrc = src;
        this.mDst = dst;
    }

