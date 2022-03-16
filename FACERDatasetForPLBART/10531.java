    /**
     * Method that creates and display a toast dialog.
     *
     * @param context The context to use.
     * @param msg The message to display.
     * @param duration How long to display the message.
     */
    public static void showToast(Context context, String msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

