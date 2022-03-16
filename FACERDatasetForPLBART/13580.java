    public void displayAlertDialog(String message, String title, String positiveText, String negativeText, final AlertDialogCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message)
                .setTitle(title);
        builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (callback != null)
                    callback.alertDialogPositiveButtonClicked(null);

                // Dismissing Dialog
                dialog.dismiss();
            }
        });

        if (negativeText != null) {
            builder.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (callback != null)
                        callback.alertDialogNegativeButtonClicked(null);

                    // Dismissing Dialog
                    dialog.dismiss();
                }
            });
        }
        builder.show();
    }

