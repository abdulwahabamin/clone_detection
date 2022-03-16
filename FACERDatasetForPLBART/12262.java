    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.mFree ^ (this.mFree >>> 32));
        result = prime * result + ((this.mMountPoint == null) ? 0 : this.mMountPoint.hashCode());
        result = prime * result + (int) (this.mTotal ^ (this.mTotal >>> 32));
        result = prime * result + (int) (this.mUsed ^ (this.mUsed >>> 32));
        return result;
    }

