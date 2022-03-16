    /**
     * Method that creates and display a toast dialog.
     *
     * @param context The context to use.
     * @param msgResourceId The resource id of the string resource to use.
     * @param duration How long to display the message.
     */
    public static void showToast(Context context, int msgResourceId, int duration) {
        showToast(context, context.getString(msgResourceId), duration);
    }

