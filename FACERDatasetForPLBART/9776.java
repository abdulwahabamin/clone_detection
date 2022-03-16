    /**
     * Constructor
     *
     * @param listener
     * {@link com.cyanogenmod.filemanager.providers.secure.ISecureChoiceCompleteListener}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public SecureChoiceRefreshListener(File cacheFile, ISecureChoiceCompleteListener listener)
            throws IllegalArgumentException {
        if (cacheFile == null) {
            throw new IllegalArgumentException("'cacheFile' cannot be null!");
        }
        if (listener == null) {
            throw new IllegalArgumentException("'listener' cannot be null!");
        }
        mCacheFile = cacheFile;
        mListener = listener;
    }

