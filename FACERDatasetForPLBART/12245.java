    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Bookmark another) {
        int c = this.mType.compareTo(another.mType);
        if (c != 0) {
            return c;
        }
        return this.mPath.compareTo(another.mPath);
    }

