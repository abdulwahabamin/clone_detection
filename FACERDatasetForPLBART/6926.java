    public static AlertDialog judgeAlertDialog(Context context, String title, String message,
                                               DialogInterface.OnClickListener okListener,
                                               DialogInterface.OnClickListener cancelListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("�?�消", cancelListener)
                .setPositiveButton("确定", okListener)
                .show();
        return alertDialog;
    }

