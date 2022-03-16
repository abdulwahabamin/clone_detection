    /**
     * Constructor of <code>OperationTimeoutException</code>.
     *
     * @param timeout Maximum time to complete operation
     * @param command Executed command
     */
    public OperationTimeoutException(long timeout, String command) {
        super(String.format("(%d) %s", Long.valueOf(timeout), command)); //$NON-NLS-1$
    }

