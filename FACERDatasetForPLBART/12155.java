    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCancel() {
        //Kill the current command on cancel request
        return killCurrentCommand();
    }

