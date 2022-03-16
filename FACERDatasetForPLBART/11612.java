    /**
     * Constructor of <code>ExecCommand</code>.
     *
     * @param console The current console
     * @param file The file to read
     * @param asyncResultListener The partial result listener
     */
    public ReadCommand(SecureConsole console, String file,
            AsyncResultListener asyncResultListener) {
        super(console);
        this.mFile = file;
        this.mAsyncResultListener = asyncResultListener;
        this.mCancelled = false;
        this.mEnded = false;
    }

