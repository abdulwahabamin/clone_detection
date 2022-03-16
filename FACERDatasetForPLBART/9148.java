    /**
     * {@inheritDoc}
     */
    @Override
    public LinkExecutable createLinkExecutable(String src, String link)
            throws CommandNotFoundException {
        try {
            return new LinkCommand(src, link);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("LinkCommand", icdEx); //$NON-NLS-1$
        }
    }

