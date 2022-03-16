    /**
     * Method that creates a new {@link AlertDialog}.
     *
     * @param context The current context
     * @param icon The icon resource
     * @param title The resource identifier of the title of the alert dialog
     * @param message The resource identifier of the message of the alert dialog
     * @param allCaps If the title must have his text in caps or not
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createAlertDialog(
            Context context, int icon, int title, int message, boolean allCaps) {
        return createAlertDialog(context, icon, title, context.getString(message), allCaps);
    }

