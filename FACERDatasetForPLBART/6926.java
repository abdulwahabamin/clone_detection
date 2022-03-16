    public static AlertDialog judgeAlertDialog(Context context, String title, String message,
                                               DialogInterface.OnClickListener okListener,
                                               DialogInterface.OnClickListener cancelListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("å?–æ¶ˆ", cancelListener)
                .setPositiveButton("ç¡®å®š", okListener)
                .show();
        return alertDialog;
    }

