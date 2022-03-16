    /**
     * Set the text that should be shown in the label of the color input.
     * Set to null to disable text.
     *
     * @param text Text that should be shown.
     */
    public void setColorLabelText(String text) {
        this.mColorLabelText = text;
        this.tvColorLabel.setText(this.mColorLabelText);
    }

