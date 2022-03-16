    /**
     * {@inheritDoc}
     */
    @Override
    protected String getRawString() {
        StringBuilder p = new StringBuilder();
        p.append(isRead() ? READ : UNASIGNED);
        p.append(isWrite() ? WRITE : UNASIGNED);
        if (isSetUID()) {
            p.append(isExecute() ? SETUID_E : SETUID);
        } else {
            p.append(isExecute() ? EXECUTE : UNASIGNED);
        }
        return p.toString();
    }

