    /**
     * Returns false if there is no setter or public field underlying this Property.
     */
    @Override
    public boolean isReadOnly() {
        return (mSetter == null && mField == null);
    }

