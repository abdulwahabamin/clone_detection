    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.mItem == null) ? 0 : this.mItem.hashCode());
        result = prime * result + this.mPosition;
        return result;
    }

