    /**
     * {@inheritDoc}
     */
    @Override
    public void realloc() throws ConsoleAllocException {
        dealloc();
        alloc();
    }

