    /**
     * Displaying Alert Dialog with EditText in it
     *
     * @param activity
     * @param title used to display alertDialog title
     * @param hint used to display hint inside EditText
     * @param defaultText used to display inside EditText
     * @param callback
     */
    public void displayAlertDialogWithEdittext(Activity activity,
                                               String title,
                                               String hint,
                                               String defaultText,
                                               final AlertDialogCallback callback) {
        
        AlertDialogHelper alertDialogHelper = new AlertDialogHelper(activity);
        alertDialogHelper.displayAlertDialogWithEdittext(title, hint, defaultText, callback);
    }

