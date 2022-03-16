    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        // Show the soft keyboard (only if the device has't a hardware keyboard)
        Configuration config = getContext().getResources().getConfiguration();
        if (config.keyboard == Configuration.KEYBOARD_NOKEYS) {
            Activity activity = (Activity)getContext();
            InputMethodManager imm =
                    (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(
                    this.mForegroundText.getWindowToken(), 0);
        }
    }

