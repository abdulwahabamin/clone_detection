    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(AID another) {
        if (this.mId < another.mId) {
            return -1;
        }
        if (this.mId > another.mId) {
            return 1;
        }
        if (this.mId == -1) {
            return this.mName.compareTo(another.mName);
        }
        return 0;
    }

