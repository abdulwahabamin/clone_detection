    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteFileExecutable createDeleteFileExecutable(String file)
            throws CommandNotFoundException {
        try {
            return new DeleteFileCommand(file);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("DeleteFileCommand", icdEx); //$NON-NLS-1$
        }
    }

