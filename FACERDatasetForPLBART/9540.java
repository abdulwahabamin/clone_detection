    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FolderUsage other = (FolderUsage) obj;
        if (this.mFolder == null) {
            if (other.mFolder != null)
                return false;
        } else if (!this.mFolder.equals(other.mFolder))
            return false;
        if (this.mNumberOfFiles != other.mNumberOfFiles)
            return false;
        if (this.mNumberOfFolders != other.mNumberOfFolders)
            return false;
        if (this.mStatistics == null) {
            if (other.mStatistics != null)
                return false;
        } else if (!this.mStatistics.equals(other.mStatistics))
            return false;
        if (this.mTotalSize != other.mTotalSize)
            return false;
        return true;
    }

