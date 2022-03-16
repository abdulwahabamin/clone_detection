    /**
     * Method that creates a new {@link AlertDialog} with three buttons.
     *
     * @param context The current context
     * @param button1 The resource identifier of the text of the button 1 (POSITIVE)
     * @param button2 The resource identifier of the text of the button 2 (NEUTRAL)
     * @param button3 The resource identifier of the text of the button 3 (NEGATIVE)
     * @param icon The icon resource
     * @param title The title of the alert dialog
     * @param content The content layout
     * @param onClickListener The listener where returns the button pressed
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createThreeButtonsDialog(Context context, int button1, int button2,
            int button3, int icon, String title, View content, OnClickListener onClickListener) {
        //Create the alert dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCustomTitle(createTitle(context, icon, title, false));
        builder.setView(content);
        AlertDialog dialog = builder.create();
        dialog.setButton(
                DialogInterface.BUTTON_POSITIVE, context.getString(button1), onClickListener);
        dialog.setButton(
                DialogInterface.BUTTON_NEUTRAL, context.getString(button2), onClickListener);
        dialog.setButton(
                DialogInterface.BUTTON_NEGATIVE, context.getString(button3), onClickListener);
        return dialog;
    }

