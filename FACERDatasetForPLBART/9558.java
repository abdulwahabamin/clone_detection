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
        History other = (History) obj;
        if (this.mItem == null) {
            if (other.mItem != null) {
                return false;
            }
        } else if (!this.mItem.equals(other.mItem)) {
            return false;
        }
        if (this.mPosition != other.mPosition) {
            return false;
        }
        return true;
    }

