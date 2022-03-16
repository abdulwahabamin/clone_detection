    /**
     * Method invoked when a enter key event is requested (button or keyboard)
     *
     * @param fromEditorAction It this method was invoked from editor action
     * @hide
     */
    void doDone(boolean fromEditorAction) {
        if (fromEditorAction) {
            // Hide the soft keyboard
            Configuration config = getContext().getResources().getConfiguration();
            if (config.keyboard == Configuration.KEYBOARD_NOKEYS) {
                Activity activity = (Activity)getContext();
                InputMethodManager imm =
                        (InputMethodManager) activity.getSystemService(
                                                Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(this.mForegroundText.getWindowToken(), 0);
            }
        }
    }

