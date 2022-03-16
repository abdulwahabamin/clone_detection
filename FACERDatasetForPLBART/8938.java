    /**
     * {@inheritDoc}
     */
    @Override
    public String getChecksum(CHECKSUMS checksum) {
        return getResult()[checksum.ordinal()];
    }

