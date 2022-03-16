    /**
     * Method that creates a new warning {@link AlertDialog}.
     *
     * @param context The current context
     * @param title The resource identifier of the title of the alert dialog
     * @param message The resource identifier of the message of the alert dialog
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createWarningDialog(Context context, int title, int message) {
        return createWarningDialog(context, title, context.getString(message));
    }

