    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount() {
        int count = getMenu().size() / 2;
        if (getMenu().size() % 2 != 0) {
            count++;
        }
        return count;
    }

