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
        GroupPermission other = (GroupPermission) obj;
        if (this.mSetGid != other.mSetGid) {
            return false;
        }
        return true;
    }

