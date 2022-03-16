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
        Permissions other = (Permissions) obj;
        if (this.mGroup == null) {
            if (other.mGroup != null) {
                return false;
            }
        } else if (!this.mGroup.equals(other.mGroup)) {
            return false;
        }
        if (this.mOthers == null) {
            if (other.mOthers != null) {
                return false;
            }
        } else if (!this.mOthers.equals(other.mOthers)) {
            return false;
        }
        if (this.mUser == null) {
            if (other.mUser != null) {
                return false;
            }
        } else if (!this.mUser.equals(other.mUser)) {
            return false;
        }
        return true;
    }

