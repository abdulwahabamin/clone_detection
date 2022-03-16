    /**
     * Constructor of <code>RelaunchableException</code>.
     *
     * @param detailMessage Message associated to the exception
     * @param throwable The cause of the exception
     * @param executable The executable that should be re-executed
     */
    public RelaunchableException(
            String detailMessage, Throwable throwable, SyncResultExecutable executable) {
        super(detailMessage, throwable);
        this.mExecutables = new ArrayList<SyncResultExecutable>();
        if (executable != null) {
            addExecutable(executable);
        }
    }

