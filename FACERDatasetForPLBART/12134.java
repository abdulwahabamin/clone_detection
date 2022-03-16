    /**
     * {@inheritDoc}
     */
    @Override
    public final void realloc() throws ConsoleAllocException {
        dealloc();
        alloc();
    }

