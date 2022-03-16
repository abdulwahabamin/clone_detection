    /**
     * Method that creates a new error {@link AlertDialog}.
     *
     * @param context The current context
     * @param title The resource identifier of the title of the alert dialog
     * @param message The resource identifier of the message of the alert dialog
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createErrorDialog(Context context, int title, int message) {
        return createErrorDialog(context, title, context.getString(message));
    }

