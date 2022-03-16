    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Permissions another) {
        String o1 = this.toRawString();
        String o2 = another.toRawString();
        return o1.compareTo(o2);
    }

