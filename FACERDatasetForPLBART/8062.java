    /**
     * Method that set the color of the picker
     *
     * @param argb The ARGB color
     * @param fromEditText If the call comes from the <code>EditText</code>
     */
    private void setColor(int argb, boolean fromEditText) {
        this.mPickerView.setColor(argb, false);
        this.mCurrentColorView.setColor(argb);
        this.mNewColorView.setColor(argb);
        if (!fromEditText) {
            this.etColor.setText(toHex(this.mNewColorView.getColor()));
        }
    }

