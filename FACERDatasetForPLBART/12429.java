    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.mFso == null) ? 0 : this.mFso.hashCode());
        long temp;
        temp = Double.doubleToLongBits(this.mRelevance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

