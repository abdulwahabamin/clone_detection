    /**
     * Constructor of <code>ChecksumCommand</code>.
     *
     * @param src The source file
     * @param asyncResultListener The partial result listener
     */
    public ChecksumCommand(
            String src, AsyncResultListener asyncResultListener) {
        super();
        this.mAsyncResultListener = asyncResultListener;
        this.mChecksums = new String[]{null, null};
        this.mSrc = new File(src);
    }

