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
        SearchResult other = (SearchResult) obj;
        if (this.mFso == null) {
            if (other.mFso != null) {
                return false;
            }
        } else if (!this.mFso.equals(other.mFso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.mRelevance) != Double.doubleToLongBits(other.mRelevance)) {
            return false;
        }
        return true;
    }

