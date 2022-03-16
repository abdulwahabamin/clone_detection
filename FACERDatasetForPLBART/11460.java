    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableCreator newCreator() {
        return new JavaExecutableCreator(this.mConsole);
    }

