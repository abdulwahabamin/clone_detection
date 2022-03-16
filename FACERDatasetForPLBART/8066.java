    /**
     * Set the text that should be shown in the new color panel.
     * Set to null to disable text.
     *
     * @param text Text that should be shown.
     */
    public void setNewColorText(String text) {
        this.mNewLabelText = text;
        this.tvNew.setText(this.mNewLabelText);
    }

