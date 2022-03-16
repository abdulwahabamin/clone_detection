    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableCreator newCreator() {
        return new SecureExecutableCreator(this.mConsole);
    }

