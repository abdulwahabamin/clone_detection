    /**
     * Set the text that should be shown in the
     * alpha slider. Set to null to disable text.
     * @param res string resource id.
     */
    public void setAlphaSliderText(int res) {
        String text = getContext().getString(res);
        setAlphaSliderText(text);
    }

