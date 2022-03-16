    /**
     * {@inheritDoc}
     */
    @Override
    public QuickFolderSearchExecutable createQuickFolderSearchExecutable(String regexp)
            throws CommandNotFoundException {
        try {
            return new QuickFolderSearchCommand(regexp);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("QuickFolderSearchCommand", icdEx); //$NON-NLS-1$
        }
    }

