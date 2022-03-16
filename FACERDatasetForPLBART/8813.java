    /**
     * Constructor of <code>MoveCommand</code>.
     *
     * @param console The current console
     * @param src The name of the file or directory to be moved
     * @param dst The name of the file or directory in which move the source file or directory
     */
    public MoveCommand(SecureConsole console, String src, String dst) {
        super(console);
        this.mSrc = src;
        this.mDst = dst;
    }

