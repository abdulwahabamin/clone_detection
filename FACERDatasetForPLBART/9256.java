    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCancel() {
        mActiveProgram.requestCancel();
        return true;
    }

