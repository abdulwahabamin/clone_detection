    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        // Hide the soft keyboard
        Configuration config = getContext().getResources().getConfiguration();
        if (config.keyboard == Configuration.KEYBOARD_NOKEYS) {
            Activity activity = (Activity)getContext();
            InputMethodManager imm =
                    (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.mForegroundText.getWindowToken(), 0);
        }
    }

