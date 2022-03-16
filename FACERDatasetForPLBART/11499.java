    /**
     * Constructor of <code>WriteCommand</code>.
     *
     * @param file The file where to write the data
     * @param asyncResultListener The partial result listener
     */
    public WriteCommand(
            String file, AsyncResultListener asyncResultListener) {
        super();
        this.mFile = file;
        this.mAsyncResultListener = asyncResultListener;
        this.mCancelled = false;
        this.mReady = false;
    }

