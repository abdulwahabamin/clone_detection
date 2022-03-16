    /**
     * @Constructor of <code>AsyncResultProgram</code>.
     *
     * @param id The resource identifier of the command
     * @param prepare Indicates if the argument must be prepared
     * @param asyncResultListener The partial result listener
     * @param args Arguments of the command (will be formatted with the arguments from
     * the command definition)
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public AsyncResultProgram(
            String id, boolean prepare, AsyncResultListener asyncResultListener, String... args)
            throws InvalidCommandDefinitionException {
        super(id, prepare, args);
        this.mAsyncResultListener = asyncResultListener;
        if (mAsyncResultListener instanceof ConcurrentAsyncResultListener) {
            ((ConcurrentAsyncResultListener) mAsyncResultListener).onRegister();
        }
        this.mPartialData = Collections.synchronizedList(new ArrayList<byte[]>());
        this.mPartialDataType = Collections.synchronizedList(new ArrayList<Byte>());
        this.mTempBuffer = new StringBuffer();
        this.mOnCancelListener = null;
        this.mOnEndListener = null;
        this.mCancelled = false;
    }

