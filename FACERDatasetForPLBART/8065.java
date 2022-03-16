    /**
     * Set the text that should be shown in the actual color panel.
     * Set to null to disable text.
     *
     * @param text Text that should be shown.
     */
    public void setCurrentColorText(String text) {
        this.mCurrentLabelText = text;
        this.tvCurrent.setText(this.mCurrentLabelText);
    }

