    /**
     * {@inheritDoc}
     */
    @Override
    public ListExecutable createFileInfoExecutable(String src, boolean followSymlinks)
            throws CommandNotFoundException {
        try {
            return new ListCommand(src, followSymlinks, this.mConsole);
        } catch (Throwable throwEx) {
            throw new CommandNotFoundException("ListCommand (FILEINFO)", throwEx); //$NON-NLS-1$
        }
    }

