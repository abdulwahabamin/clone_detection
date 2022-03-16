    /**
     * Method that sets the current text value.
     *
     * @param value The value to set to current text value
     */
    public void setText(String value) {
        this.mBackgroundText.setVisibility(View.INVISIBLE);
        this.mForegroundText.setText(value);
        this.mBackgroundText.setText(""); //$NON-NLS-1$
        onTextChanged(value);
        this.mForegroundText.requestFocus();
        this.mForegroundText.setSelection(value.length());
        int lines = this.mBackgroundText.getLineCount();
        this.mForegroundText.setLines(lines <= 0 ? 1 : lines);
    }

