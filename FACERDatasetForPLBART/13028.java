    /**
     * Method that need to be invoked when a string was changed
     *
     * @param value The new string
     * @hide
     */
    void onTextChanged(String value) {
        this.mFilter = 0;
        if (this.mOnTextChangedListener != null) {
            //Communicate the change
            this.mOnTextChangedListener.onTextChanged(
                                value.toString(), this.mData);

            if (this.mCompletionString != null &&
                    !value.toString().endsWith(this.mCompletionString)) {
                //Autocomplete
                autocomplete();
            } else {
                this.mBackgroundText.setVisibility(View.INVISIBLE);
            }
        }
    }

