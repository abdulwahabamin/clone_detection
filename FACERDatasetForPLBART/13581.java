    /**
     * Displaying Alert Dialog with EditText in it
     *
     * @param title used to display alertDialog title
     * @param hint used to display hint inside EditText
     * @param defaultText used to display inside EditText
     * @param callback
     */
    public void displayAlertDialogWithEdittext(String title,
                                               String hint,
                                               String defaultText,
                                               final AlertDialogCallback callback) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        final View dialogCustomView = layoutInflater.inflate(R.layout.alertdialog_edittext, null);
        alertDialogBuilder.setView(dialogCustomView);

        final EditText dialog_editText = (EditText) dialogCustomView.findViewById(R.id.dialog_editText);
        dialog_editText.setHint(hint);
        if (defaultText != null)
            dialog_editText.setText(defaultText);

        alertDialogBuilder.setTitle(title);
//        alertDialogBuilder.setMessage("");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    // Handling textEntered here,
                    // preventing to add code handling multiple times later
                    String textEntered = dialog_editText.getText().toString();

                    if (textEntered != null && !("".equalsIgnoreCase(textEntered)))
                        callback.alertDialogPositiveButtonClicked(textEntered);
                    else
                        callback.alertDialogNegativeButtonClicked("Invalid Text Entered");
                }
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null)
                    callback.alertDialogNegativeButtonClicked(null);

                // Do nothing
                dialog.dismiss();
            }
        });

        alertDialogBuilder.show();
    }

