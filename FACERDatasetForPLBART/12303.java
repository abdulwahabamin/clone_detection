    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(FileSystemObject another) {
        String o1 = this.getFullPath();
        String o2 = another.getFullPath();
        return o1.compareTo(o2);
    }

