    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.mFolder == null) ? 0 : this.mFolder.hashCode());
        result = prime * result + this.mNumberOfFiles;
        result = prime * result + this.mNumberOfFolders;
        result = prime * result
                + ((this.mStatistics == null) ? 0 : this.mStatistics.hashCode());
        result = prime * result + (int) (this.mTotalSize ^ (this.mTotalSize >>> 32));
        return result;
    }

