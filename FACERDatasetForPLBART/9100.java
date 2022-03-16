    /**
     * Method that returns if the standard error must be
     * ignored safely by the shell, and don't check for errors
     * like <code>NoSuchFileOrDirectory</code> or
     * <code>Permission denied</code> by the shell.
     *
     * @return boolean If the standard error must be ignored
     * @hide
     */
    @SuppressWarnings("static-method")
    public boolean isIgnoreShellStdErrCheck() {
        return false;
    }

