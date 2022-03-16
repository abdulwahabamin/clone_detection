    /**
     * {@inheritDoc}
     */
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return Integer.valueOf(a.getColor(index, 0));
    }

