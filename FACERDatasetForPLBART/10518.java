    /**
     * Method that creates a new YES/ALL/NO {@link AlertDialog}.
     *
     * @param context The current context
     * @param title The resource identifier of the title of the alert dialog
     * @param message The resource identifier of the message of the alert dialog
     * @param onClickListener The listener where returns the button pressed
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createYesNoAllDialog(
            Context context, int title, int message, OnClickListener onClickListener) {
        return createYesNoAllDialog(context, title, context.getString(message), onClickListener);
    }

