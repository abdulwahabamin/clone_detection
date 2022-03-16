    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.mPath == null) ? 0 : this.mPath.hashCode());
        result = prime * result + ((this.mName == null) ? 0 : this.mName.hashCode());
        result = prime * result + ((this.mType == null) ? 0 : this.mType.hashCode());
        return result;
    }

