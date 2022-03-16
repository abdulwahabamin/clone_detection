    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCancellable() {
        //By defect an asynchronous command is cancellable
        return true;
    }

