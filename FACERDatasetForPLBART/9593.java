    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OthersPermission other = (OthersPermission) obj;
        if (this.mStickybit != other.mStickybit) {
            return false;
        }
        return true;
    }

