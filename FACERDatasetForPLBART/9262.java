    /**
     * Constructor of <code>RelaunchableException</code>.
     *
     * @param executable The executable that should be re-executed
     */
    public RelaunchableException(SyncResultExecutable executable) {
        super();
        this.mExecutables = new ArrayList<SyncResultExecutable>();
        if (executable != null) {
            addExecutable(executable);
        }
    }

