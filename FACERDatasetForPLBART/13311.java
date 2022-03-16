    /**
     * Method that creates a three buttons question {@link AlertDialog}.
     *
     * @param context The current context
     * @param button1 The resource identifier of the text of the button 1 (POSITIVE)
     * @param button2 The resource identifier of the text of the button 2 (NEUTRAL)
     * @param button3 The resource identifier of the text of the button 3 (NEGATIVE)
     * @param title The resource id of the title of the alert dialog
     * @param message The message of the alert dialog
     * @param onClickListener The listener where returns the button pressed
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createThreeButtonsQuestionDialog(
            Context context, int button1, int button2, int button3,
            int title, String message, OnClickListener onClickListener) {
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
                DialogInterface.BUTTON_POSITIVE, context.getString(button1), onClickListener);
        dialog.setButton(
                DialogInterface.BUTTON_NEUTRAL, context.getString(button2), onClickListener);
        dialog.setButton(
                DialogInterface.BUTTON_NEGATIVE, context.getString(button3), onClickListener);
        return dialog;
    }

