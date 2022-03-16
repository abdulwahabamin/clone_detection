    /**
     * Constructor of <code>MoveCommand</code>.
     *
     * @param src The name of the file or directory to be moved
     * @param dst The name of the file or directory in which move the source file or directory
     */
    public MoveCommand(String src, String dst) {
        super();
        this.mSrc = src;
        this.mDst = dst;
    }

