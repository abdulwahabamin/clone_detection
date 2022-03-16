    /**
     * Constructor of <code>RelaunchableException</code>.
     *
     * @param detailMessage Message associated to the exception
     * @param executable The executable that should be re-executed
     */
    public RelaunchableException(String detailMessage, SyncResultExecutable executable) {
        super(detailMessage);
        this.mExecutables = new ArrayList<SyncResultExecutable>();
        if (executable != null) {
            addExecutable(executable);
        }
    }

