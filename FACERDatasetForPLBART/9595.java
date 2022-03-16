    /**
     * {@inheritDoc}
     */
    @Override
    protected String getRawString() {
        StringBuilder p = new StringBuilder();
        p.append(isRead() ? READ : UNASIGNED);
        p.append(isWrite() ? WRITE : UNASIGNED);
        if (isStickybit()) {
            p.append(isExecute() ? STICKY_E : STICKY);
        } else {
            p.append(isExecute() ? EXECUTE : UNASIGNED);
        }
        return p.toString();
    }

