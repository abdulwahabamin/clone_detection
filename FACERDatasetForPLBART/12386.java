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
        Permission other = (Permission) obj;
        if (this.mExecute != other.mExecute) {
            return false;
        }
        if (this.mRead != other.mRead) {
            return false;
        }
        if (this.mWrite != other.mWrite) {
            return false;
        }
        return true;
    }

