    /**
     * Constructor of <code>WriteCommand</code>.
     *
     * @param console The current console
     * @param file The file where to write the data
     * @param asyncResultListener The partial result listener
     */
    public WriteCommand(SecureConsole console, String file,
            AsyncResultListener asyncResultListener) {
        super(console);
        this.mFile = file;
        this.mAsyncResultListener = asyncResultListener;
        this.mCancelled = false;
        this.mReady = false;
    }

