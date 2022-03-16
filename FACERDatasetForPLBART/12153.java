    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onEnd() {
        //Kill the current command on end request
        return killCurrentCommand();
    }

