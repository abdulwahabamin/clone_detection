    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Identity [user=" + this.mUser + ", group=" //$NON-NLS-1$//$NON-NLS-2$
                + this.mGroup + ", groups=" +  //$NON-NLS-1$
                Arrays.toString(
                        this.mGroups.toArray(new Group[this.mGroups.size()])) + "]"; //$NON-NLS-1$
    }

