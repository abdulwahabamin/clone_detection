        /**
         * Method that set the style of the dialog.
         *
         * @param ctx The current context
         * @param dialog The dialog which apply the style
         */
        @SuppressWarnings("deprecation")
        public void setDialogStyle(Context ctx, AlertDialog dialog) {
            applyButtonStyle(ctx, dialog.getButton(DialogInterface.BUTTON1));
            applyButtonStyle(ctx, dialog.getButton(DialogInterface.BUTTON2));
            applyButtonStyle(ctx, dialog.getButton(DialogInterface.BUTTON3));
            applyButtonStyle(ctx, dialog.getButton(DialogInterface.BUTTON_NEGATIVE));
            applyButtonStyle(ctx, dialog.getButton(DialogInterface.BUTTON_NEUTRAL));
            applyButtonStyle(ctx, dialog.getButton(DialogInterface.BUTTON_POSITIVE));
        }

