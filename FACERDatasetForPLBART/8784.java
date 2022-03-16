    /**
     * Constructor of <code>FindCommand</code>.
     *
     * @param console The secure console
     * @param directory The absolute directory where start the search
     * @param query The terms to be searched
     * @param asyncResultListener The partial result listener
     */
    public FindCommand(SecureConsole console, String directory, Query query,
            ConcurrentAsyncResultListener asyncResultListener) {
        super(console);
        // This command should start the search in the root directory or in a descendent folder
        if (!getConsole().isSecureStorageResource(directory)) {
            this.mDirectory = getConsole().getVirtualMountPoint().getAbsolutePath();
        } else {
            this.mDirectory = directory;
        }
        this.mQueryRegExp = createRegexp(directory, query);
        this.mAsyncResultListener = asyncResultListener;
        if (mAsyncResultListener instanceof ConcurrentAsyncResultListener) {
            ((ConcurrentAsyncResultListener) mAsyncResultListener).onRegister();
        }
        this.mCancelled = false;
        this.mEnded = false;
    }

