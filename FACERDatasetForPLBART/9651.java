    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(SearchResult another) {
        if (this.mRelevance != another.mRelevance) {
            return Double.valueOf(this.mRelevance).compareTo(
                                        Double.valueOf(another.mRelevance)) * -1;
        }
        return this.mFso.compareTo(another.mFso);
    }

