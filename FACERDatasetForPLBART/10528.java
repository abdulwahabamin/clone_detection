    /**
     * Method that creates and returns the title of the dialog.
     *
     * @param context The current context
     * @param message The the message of the alert dialog
     * @return The title view
     */
    private static View createMessage(Context context, String message) {
        //Inflate the dialog layouts
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View lyMessage = li.inflate(
                            R.layout.dialog_message,
                            null);
        TextView vMsg = (TextView)lyMessage.findViewById(R.id.dialog_message);
        // Dialog need to be filled with at least two lines to fill the background dialog,
        // so we add a new additional line to the message
        vMsg.setText(message + "\n"); //$NON-NLS-1$

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setBackgroundDrawable(context, lyMessage, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(context, vMsg, "text_color"); //$NON-NLS-1$

        return lyMessage;
    }

