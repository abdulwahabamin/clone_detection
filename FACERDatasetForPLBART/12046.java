    /**
     * Method that add a new executable to the queue of command to be re-executed.
     *
     * @param executable The executable to add
     */
    public void addExecutable(SyncResultExecutable executable) {
        this.mExecutables.add(executable);
    }

