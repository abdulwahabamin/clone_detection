    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartParsePartialResult() {
        this.mFolderUsage = new FolderUsage(this.mDirectory);
    }

