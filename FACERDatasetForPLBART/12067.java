    /**
     * Constructor of <code>SecureConsole</code>
     *
     * @param ctx The current context
     */
    private SecureConsole(Context ctx, int bufferSize) {
        super(ctx);
        mIsMounted = false;
        mBufferSize = bufferSize;
        mSyncHandler = new Handler(mSyncCallback);
        mStorageRoot = getSecureStorageRoot();
        mStorageName = getSecureStorageName();

        // Save a copy of the console. This has a unique instance for all the app
        if (sConsole != null) {
            sConsole = this;
        }
    }

