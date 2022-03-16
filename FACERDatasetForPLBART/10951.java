    /**
     * {@inheritDoc}
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        this.mEditStart = start;
        this.mEditEnd = start + count;
    }

