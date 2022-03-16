    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DiskUsage other = (DiskUsage) obj;
        if (this.mFree != other.mFree) {
            return false;
        }
        if (this.mMountPoint == null) {
            if (other.mMountPoint != null) {
                return false;
            }
        } else if (!this.mMountPoint.equals(other.mMountPoint)) {
            return false;
        }
        if (this.mTotal != other.mTotal) {
            return false;
        }
        if (this.mUsed != other.mUsed) {
            return false;
        }
        return true;
    }

