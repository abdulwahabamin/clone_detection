    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        FolderUsage other = new FolderUsage(this.mFolder);
        other.mNumberOfFolders = this.mNumberOfFolders;
        other.mNumberOfFiles = this.mNumberOfFiles;
        other.mTotalSize = this.mTotalSize;
        other.mStatistics = this.mStatistics.clone();
        return super.clone();
    }

