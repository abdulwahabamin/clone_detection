    public static AlertDialog judgeAlertDialog(Context context, String title, String message, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancleListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("ç¡®å®š", okListener)
                .setPositiveButton("å?–æ¶ˆ", cancleListener).show();
        return alertDialog;
    }

