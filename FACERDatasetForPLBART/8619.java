    /**
     * Constructor of <code>FindCommand</code>.
     *
     * @param directory The absolute directory where start the search
     * @param query The terms to be searched
     * @param asyncResultListener The partial result listener
     */
    public FindCommand(String directory, Query query,
            ConcurrentAsyncResultListener asyncResultListener) {
        super();
        this.mDirectory = directory;
        this.mQueryRegExp = createRegexp(directory, query);
        this.mAsyncResultListener = asyncResultListener;
        if (mAsyncResultListener instanceof ConcurrentAsyncResultListener) {
            ((ConcurrentAsyncResultListener) mAsyncResultListener).onRegister();
        }
        this.mCancelled = false;
        this.mEnded = false;
    }

