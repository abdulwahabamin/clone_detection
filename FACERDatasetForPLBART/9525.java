    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        FileSystemObject other = (FileSystemObject) obj;
        if (this.mName == null) {
            if (other.mName != null)
                return false;
        } else if (!this.mName.equals(other.mName))
            return false;
        if (this.mParent == null) {
            if (other.mParent != null)
                return false;
        } else if (!this.mParent.equals(other.mParent))
            return false;
        return true;
    }

