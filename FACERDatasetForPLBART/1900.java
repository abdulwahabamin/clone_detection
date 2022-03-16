    private AlertDialog getRequestAgainAlertDialog(Activity view, String permission_name, final int request_code) {
        return new AlertDialog.Builder(view).setTitle("Permission Required")
                .setMessage("We need " + permission_name + " permissions")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermission(deniedpermissions.toArray(new String[deniedpermissions.size()]), request_code);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getListener().onPermissionRejectedManyTimes(deniedpermissions, request_code);
                    }
                }).show();
    }

