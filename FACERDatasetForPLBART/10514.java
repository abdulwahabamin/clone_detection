    /**
     * Method that creates a new {@link AlertDialog}.
     *
     * @param context The current context
     * @param icon The icon resource
     * @param title The resource identifier of the title of the alert dialog
     * @param message The message of the alert dialog
     * @param allCaps If the title must have his text in caps or not
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createAlertDialog(
            Context context, int icon, int title, String message, boolean allCaps) {
        //Create the alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCustomTitle(createTitle(context, icon, context.getString(title), allCaps));
        builder.setView(createMessage(context, message));
        builder.setPositiveButton(context.getString(R.string.ok), null);
        return builder.create();
    }

