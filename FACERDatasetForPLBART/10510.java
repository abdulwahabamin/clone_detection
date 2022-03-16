    /**
     * Method that creates a new warning {@link AlertDialog}.
     *
     * @param context The current context
     * @param title The resource identifier of the title of the alert dialog
     * @param message The message of the alert dialog
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createWarningDialog(Context context, int title, String message) {
        return createAlertDialog(
                context,
                0,
                title,
                message,
                false);
    }

