    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableCreator newCreator() {
        return new ShellExecutableCreator(this.mConsole);
    }

