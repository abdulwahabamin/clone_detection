    /**
     * Constructor of <code>ExecCommand</code>.
     *
     * @param file The file to read
     * @param asyncResultListener The partial result listener
     */
    public ReadCommand(
            String file, AsyncResultListener asyncResultListener) {
        super();
        this.mFile = file;
        this.mAsyncResultListener = asyncResultListener;
        this.mCancelled = false;
        this.mEnded = false;
    }

