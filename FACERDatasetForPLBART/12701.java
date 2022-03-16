    /**
     * {@inheritDoc}
     */
    @Override
    public void onAsyncStart() {
        this.mDrawingFolderUsage = false;
        this.mFolderUsage = new FolderUsage(this.mFso.getFullPath());
        printFolderUsage(true, false);
    }

