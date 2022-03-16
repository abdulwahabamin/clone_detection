    /**
     * Constructor of <code>ChecksumCommand</code>.
     *
     * @param console The current console
     * @param src The source file
     * @param asyncResultListener The partial result listener
     */
    public ChecksumCommand(SecureConsole console, String src,
            AsyncResultListener asyncResultListener) {
        super(console);
        this.mAsyncResultListener = asyncResultListener;
        this.mChecksums = new String[]{null, null};
        this.mSrc = new File(src);
    }

