    /**
     * Constructor of <code>FolderUsageCommand</code>.
     *
     * @param console The secure console
     * @param directory The absolute directory to compute
     * @param asyncResultListener The partial result listener
     */
    public FolderUsageCommand(SecureConsole console, String directory,
            AsyncResultListener asyncResultListener) {
        super(console);
        this.mDirectory = directory;
        this.mAsyncResultListener = asyncResultListener;
        this.mFolderUsage = new FolderUsage(directory);
        this.mCancelled = false;
        this.mEnded = false;
    }

