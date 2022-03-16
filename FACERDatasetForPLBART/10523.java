    /**
     * Method that creates a new {@link AlertDialog}.
     *
     * @param context The current context
     * @param icon The icon resource
     * @param title The title of the alert dialog
     * @param content The content layout
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createDialog(Context context, int icon, String title, View content) {
        //Create the alert dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCustomTitle(createTitle(context, icon, title, false));
        builder.setView(content);
        return builder.create();
    }

