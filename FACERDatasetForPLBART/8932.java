    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartParsePartialResult() {
        this.mChecksums[0] = null;
        this.mChecksums[1] = null;
        this.mChecksumsCounter = 0;
        this.mPartial = ""; //$NON-NLS-1$
    }

