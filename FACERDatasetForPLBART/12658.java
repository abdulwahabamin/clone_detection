    /**
     * Method that draw the message
     *
     * @param msg The message
     * @param scroll Scroll to bottom
     * @hide
     */
    void drawMessage(String msg, boolean scroll) {
        // Any message?
        if (msg != null && msg.length() > 0) {
            final TextView tv = ExecutionDialog.this.mTvOutput;
            tv.setText(msg);

            // Scroll to bottom
            if (scroll) {
                final Layout layout = tv.getLayout();
                if (layout != null) {
                    int scrollDelta =
                            layout.getLineBottom(
                                    tv.getLineCount() - 1) - tv.getScrollY() - tv.getHeight();
                    if (scrollDelta > 0) {
                        tv.scrollBy(0, scrollDelta);
                    }
                }
            } else {
                tv.scrollBy(0, 0);
            }
        }
    }

