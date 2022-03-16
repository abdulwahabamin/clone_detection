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
        UserPermission other = (UserPermission) obj;
        if (this.mSetuid != other.mSetuid) {
            return false;
        }
        return true;
    }

