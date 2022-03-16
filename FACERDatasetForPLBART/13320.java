    /**
     * Method that delegates the display of a dialog. This method applies the style to the
     * dialog, so all dialogs of the application MUST used this method to display the dialog.
     *
     * @param context The current context
     * @param dialog The dialog to show
     */
    public static void delegateDialogShow(Context context, AlertDialog dialog) {
        boolean isActivityFinishing = false;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity instanceof NavigationActivity) {
                ((NavigationActivity) activity).updateActiveDialog(dialog);
            }
            isActivityFinishing = activity.isFinishing();
        }

        if (!isActivityFinishing) {
            // Show the dialog
            dialog.show();
        }

        // Apply theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setDialogStyle(context, dialog);
    }

