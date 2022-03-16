    /**
     * Method that creates a new YES/NO {@link AlertDialog}.
     *
     * @param context The current context
     * @param title The resource identifier of the title of the alert dialog
     * @param message The message of the alert dialog
     * @param onClickListener The listener where returns the button pressed
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createYesNoDialog(
            Context context, int title, String message, OnClickListener onClickListener) {
        //Create the alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCustomTitle(
                createTitle(
                        context,
                        0,
                        context.getString(title),
                        false));
        builder.setView(createMessage(context, message));
        AlertDialog dialog = builder.create();
        dialog.setButton(
                DialogInterface.BUTTON_POSITIVE, context.getString(R.string.yes), onClickListener);
        dialog.setButton(
                DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.no), onClickListener);
        return dialog;
    }

