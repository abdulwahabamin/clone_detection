    /**
     * Constructor of <code>FolderUsageCommand</code>.
     *
     * @param directory The absolute directory to compute
     * @param asyncResultListener The partial result listener
     */
    public FolderUsageCommand(
            String directory, AsyncResultListener asyncResultListener) {
        super();
        this.mDirectory = directory;
        this.mAsyncResultListener = asyncResultListener;
        this.mFolderUsage = new FolderUsage(directory);
        this.mCancelled = false;
        this.mEnded = false;
    }

