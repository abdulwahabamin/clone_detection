    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(History another) {
        return Integer.valueOf(this.mPosition).compareTo(Integer.valueOf(another.mPosition));
    }

