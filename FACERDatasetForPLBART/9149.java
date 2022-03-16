    /**
     * {@inheritDoc}
     */
    @Override
    public ListExecutable createListExecutable(String src) throws CommandNotFoundException {
        try {
            return new ListCommand(src, this.mConsole);
        } catch (Throwable throwEx) {
            throw new CommandNotFoundException("ListCommand (DIRECTORY)", throwEx); //$NON-NLS-1$
        }
    }

