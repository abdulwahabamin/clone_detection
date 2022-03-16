    /**
     * Method that creates a new {@link AlertDialog}.
     *
     * @param context The current context
     * @param icon The icon resource
     * @param title The resource identifier of the title of the alert dialog
     * @param content The content layout
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createDialog(Context context, int icon, int title, View content) {
        return createDialog(context, icon, context.getString(title), content);
    }

