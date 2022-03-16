    /**
     * {@inheritDoc}
     */
    @Override
    public void afterTextChanged(Editable s) {
        setDirty(true);
        if (this.mSyntaxHighlightProcessor != null) {
            this.mSyntaxHighlightProcessor.process(s, this.mEditStart, this.mEditEnd);
        }
    }

