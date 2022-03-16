    public static AlertDialog judgeAlertDialog(Context context, String title, String message, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancleListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("确定", okListener)
                .setPositiveButton("�?�消", cancleListener).show();
        return alertDialog;
    }

