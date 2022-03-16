    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.mId;
        result = prime * result + ((this.mName == null) ? 0 : this.mName.hashCode());
        return result;
    }

